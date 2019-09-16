package com.hroniko.pnl.logic;



import com.hroniko.pnl.entities.catalog.Capex;
import com.hroniko.pnl.entities.catalog.Opex;
import com.hroniko.pnl.entities.nodes.CalcNodeSeries;
import com.hroniko.pnl.entities.price.PriceItem;
import com.hroniko.pnl.entities.results.PnLCalculationNodeResult;
import com.hroniko.pnl.entities.results.PnLCalculationResult;
import com.hroniko.pnl.services.PnLHelper;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static com.hroniko.pnl.entities.constants.AttitudeToItems.SUMMARY;
import static com.hroniko.pnl.entities.constants.NodeType.CONST;

@Slf4j
@Service
@RequiredArgsConstructor
@Primary
public class ParallelCalculationQuoteLogic implements CalculationQuoteLogic {

    @Autowired
    PnLHelper pnLHelper;

    public Mono<PnLCalculationResult> calculate(Quote quote){

        List<PriceItem> priceItems = pnLHelper.getPriceItemsByQuote(quote);
        List<CalcNodeSeries> finalCalcNodes = pnLHelper.getFinalCalcNodeSeries();
        recalculateNodeValues(finalCalcNodes, priceItems);

        return Mono.just(new PnLCalculationResult()
                .setName("PnL Calculation Result v 0.00") // TODO set generate result name
                .setCustomerId("123") // TODO set customer id
                .setCustomerName("Customer Test") // TODO set customer name
                .setNodes(finalCalcNodes.stream()
                        .map(fcn -> new PnLCalculationNodeResult()
                                .setName(fcn.getDescription())
                                .setShortName(fcn.getName())
                                .setValue(fcn.getValue().toString())
                                .setCurrencyCode(fcn.getCurrencyCode())
                                .setPercent(fcn.isPercent())
                                .setMaxValue(fcn.getMaxValue())
                                .setMinValue(fcn.getMinValue()))
                        .collect(Collectors.toList())));
    }

    private Map<BigInteger, Double> getOferingToOpexMap(){
        List<Opex> opexes = pnLHelper.getAllOpex();
        return opexes == null
                ? new HashMap<>()
                : opexes.stream().collect(
                Collectors.toMap(Opex::getOfferingId, Opex::getValue));
    }

    private Map<BigInteger, Double> getOferingToCapexMap(){
        List<Capex> capexes = pnLHelper.getAllCapex();
        return capexes == null
                ? new HashMap<>()
                : capexes.stream().collect(
                Collectors.toMap(Capex::getOfferingId, Capex::getValue));
    }


    private void recalculateNodeValues(List<CalcNodeSeries> calcNodes, List<PriceItem> priceItems){
        Map<BigInteger, Double> offeringToCapexMap = getOferingToCapexMap();
        Map<BigInteger, Double> offeringToOpexMap = getOferingToOpexMap();
        calcNodes.forEach(calcNode -> recalculateValues(calcNode, priceItems, offeringToCapexMap, offeringToOpexMap ));
    }


    private void recalculateValues(CalcNodeSeries parent,
                                   List<PriceItem> priceItems,
                                   Map<BigInteger, Double> capexMap,
                                   Map<BigInteger, Double> opexMap){

        if (parent == null) return;
        List<CalcNodeSeries> childs = parent.getCalcNodes();
        if (childs == null) childs = new ArrayList<>();

        for (CalcNodeSeries child : childs) {
            if (child.getValue() == null) recalculateValues(child, priceItems, capexMap, opexMap);
        }

        if (parent.getValue() != null) return;

        List<Double> values = new ArrayList<>();

        switch (parent.getName()){
            /* Enrich by CAPEX catalog */
            case "RCAPT":
                values = priceItems.stream()
                        .map(priceItem -> capexMap.get(priceItem.getOfferingId()))
                        .map(value -> value == null ? 0.0 : value)
                        .collect(Collectors.toList());
                break;
            /* Enrich by OPEX catalog */
            case "OPEOO":
                values = priceItems.stream()
                        .map(priceItem -> opexMap.get(priceItem.getOfferingId()))
                        .map(value -> value == null ? 0.0 : value)
                        .collect(Collectors.toList());
                break;
            /* Enrich by price */
            case "VEXTMRC":
                values = priceItems.stream()
                        .map(PriceItem::getTotalMRC)
                        .collect(Collectors.toList());
                break;
            /* Enrich by price */
            case "VEXTNRC":
                values = priceItems.stream()
                        .map(PriceItem::getTotalNRC)
                        .collect(Collectors.toList());
        }

        if (!values.isEmpty())
            parent.setValues(values);

        if (parent.getValues().isEmpty()){
            for (int i = 0; i < priceItems.size(); i++){
                Double value = calculateValue(parent, childs, i);
                parent.addValueToValues(value);
            }
        }

        /* if type != const, accumulate value */
        if (!CONST.equals(parent.getType())) {
            values = parent.getValues();
            parent.setValue(values.stream().reduce(0.0, Double::sum));
        }

        /* check summary or every calculate */
        if ( parent.getFinal() && SUMMARY.equals(parent.getAttitudeToItems())){
            Double value = calculateValue(parent, childs, null);
            parent.setValue(value);
        }

        /* mix fix */
        if (parent.getValue() == null)
            parent.setValue(parent.getValues().get(0));

    }

    private Double calculateValue(CalcNodeSeries parent, List<CalcNodeSeries> childList, Integer pos){
        // if pos = null or -1, calculate as single mode -> as Summary value
        String formula = pnLHelper.getFormulaFromCalcNode(parent);
        Set<String> variables = new HashSet<>();
        Map<String, Double> variableValues = new HashMap<>();
        for (CalcNodeSeries calcNode : childList) {
            String name = calcNode.getName().trim();
            Double value;
            if (pos == null || pos < 0){
                value = calcNode.getValue();
            } else {
                value = calcNode.getValueFromValues(pos);
            }
            variables.add(name);
            variableValues.put(name, value);
        }
        Expression expression = new ExpressionBuilder(formula)
                .variables(variables)
                .build()
                .setVariables(variableValues);

        return expression.evaluate();
    }
}
