package com.hroniko.pnl.core;

import com.hroniko.pnl.entity.catalog.Capex;
import com.hroniko.pnl.entity.catalog.Opex;
import com.hroniko.pnl.entity.nodes.CalcNode;
import com.hroniko.pnl.entity.price.PriceItem;
import com.hroniko.pnl.entity.results.PnLCalculationNodeResult;
import com.hroniko.pnl.entity.results.PnLCalculationResult;
import com.hroniko.pnl.utils.PnLHelper;
import com.hroniko.pnl.utils.entity.CalcNodeSeries;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static com.hroniko.pnl.entity.constants.AttitudeToItems.SUMMARY;
import static com.hroniko.pnl.entity.constants.NodeType.CONST;

@Slf4j
@Service
@RequiredArgsConstructor
public class SerialCalculationQuoteLogic implements CalculationQuoteLogic {

    @Autowired
    PnLHelper pnLHelper;

    public Mono<PnLCalculationResult> calculate(Quote quote){

        List<PriceItem> priceItems = pnLHelper.getPriceItemsByQuote(quote);
        priceItems = priceItems.stream().filter(pi -> pi.getTotalMRC() + pi.getTotalNRC() > 0.0).collect(Collectors.toList());

        List<CalcNode> allCalcNodes = pnLHelper.getAllCalcNodes();
        List<CalcNode> finalCalcNodes = allCalcNodes.stream()
                .filter(CalcNode::getFinal)
                .collect(Collectors.toList());

        // Create all pre-result value map
        Map<String, Double> allValueMap = new HashMap<>();
        allCalcNodes.forEach(cn -> allValueMap.put(cn.getName(), 0d));

        // Create result indicators map name-value
        Map<String, Double> indicatorValueMap = new HashMap<>();
        finalCalcNodes.forEach(cn -> indicatorValueMap.put(cn.getName(), 0d));

        priceItems.forEach(priceItem -> {
            enrichByPexCatalog(allCalcNodes, priceItem.getOfferingId());
            enrichByPrice(allCalcNodes, priceItem);
            recalculateValues(finalCalcNodes);
            checkAndSaveResult(finalCalcNodes, indicatorValueMap);
            checkAndSaveResult(allCalcNodes, allValueMap);
            clearValues(finalCalcNodes);
        });

        // secondary calculate for Attitude to Items in "Summary" status:
        allCalcNodes.stream()
                .filter(cn -> SUMMARY.equals(cn.getAttitudeToItems()))
                .forEach(calcNodeSummary -> {
                    String name = calcNodeSummary.getName();
                    if (indicatorValueMap.containsKey(name)) {
                        Double value = recalculateSummaryResult(allValueMap, calcNodeSummary);
                        allValueMap.put(name, value);
                        indicatorValueMap.put(name, value);
                    }
                });

        return Mono.just(new PnLCalculationResult()
                .setName("PnL Calculation Result v 0.00") // TODO set generate result name
                .setCustomerId("123") // TODO set customer id
                .setCustomerName("Customer Test") // TODO set customer name
                .setNodes(finalCalcNodes.stream()
                        .map(fcn -> new PnLCalculationNodeResult()
                                .setName(fcn.getDescription())
                                .setShortName(fcn.getName())
                                .setValue(indicatorValueMap.get(fcn.getName()).toString())
                                .setCurrencyCode(fcn.getCurrencyCode())
                                .setPercent(fcn.isPercent())
                                .setMaxValue(fcn.getMaxValue())
                                .setMinValue(fcn.getMinValue()))
                        .collect(Collectors.toList())));
    }

    private void enrichByPexCatalog(List<CalcNode> calcNodes, BigInteger offerId){
        List<Capex> capexList = pnLHelper.getAllCapex();
        List<Opex> opexList = pnLHelper.getAllOpex();

        Map<BigInteger, Double> capexMap = capexList == null
                ? new HashMap<>()
                : capexList.stream().collect(
                Collectors.toMap(Capex::getOfferingId, Capex::getValue));

        Map<BigInteger, Double> opexMap = opexList == null
                ? new HashMap<>()
                : opexList.stream().collect(
                Collectors.toMap(Opex::getOfferingId, Opex::getValue));

        calcNodes.stream()
                .filter(calcNode -> "RCAPT".equals(calcNode.getName()))
                .forEach(calcNode -> {
                    Double value = capexMap.get(offerId);
                    if (value != null){
                        //calcNode.setFormula(value.toString());
                        calcNode.setValue(value);
                    }
                });

        calcNodes.stream()
                .filter(calcNode -> "OPEOO".equals(calcNode.getName()))
                .forEach(calcNode -> {
                    Double value = opexMap.get(offerId);
                    if (value != null){
                        //calcNode.setFormula(value.toString());
                        calcNode.setValue(value);
                    }
                });
    }

    private void enrichByPrice(List<CalcNode> calcNodes, PriceItem priceItem){

        calcNodes.stream()
                .filter(calcNode -> "VEXTMRC".equals(calcNode.getName()))
                .forEach(calcNode -> {
                    calcNode.setValue(priceItem.getTotalMRC());
                });

        calcNodes.stream()
                .filter(calcNode -> "VEXTNRC".equals(calcNode.getName()))
                .forEach(calcNode -> {
                    calcNode.setValue(priceItem.getTotalNRC());
                });
    }



    private void recalculateValues(List<CalcNode> calcNodes){
        calcNodes.forEach(this::recalculateValues);
    }

    private void recalculateValues(CalcNode parent) {

        if (parent == null) return;
        List<CalcNode> childs = parent.getCalcNodes();
        if (childs == null) childs = new ArrayList<>();

        for (CalcNode child : childs) {
            if (child.getValue() == null) recalculateValues(child);
        }

        if (parent.getValue() != null) return;
        String formula = pnLHelper.getFormulaFromCalcNode(parent);
        Set<String> variables = new HashSet<>();
        Map<String, Double> variableValues = new HashMap<>();
        childs.forEach(calcNode -> {
            String name = calcNode.getName().trim();
            Double value = calcNode.getValue();
            variables.add(name);
            variableValues.put(name, value);
        });

        Expression expression = new ExpressionBuilder(formula)
                .variables(variables)
                .build()
                .setVariables(variableValues);
        Double value = expression.evaluate();
        parent.setValue(value);
    }

    private Double recalculateSummaryResult(Map<String, Double> allValueMap, CalcNode calcNodeResult) {
        String formula = pnLHelper.getFormulaFromCalcNode(calcNodeResult);

        Set<String> variables = new HashSet<>();
        Map<String, Double> variableValues = new HashMap<>();

        List<CalcNode> childs = calcNodeResult.getCalcNodes();
        if (childs == null) childs = new ArrayList<>();

        childs.forEach(calcNode -> {
            String name = calcNode.getName().trim();
            Double value = allValueMap.get(name);
            variables.add(name);
            variableValues.put(name, value);
        });

        Expression expression = new ExpressionBuilder(formula)
                .variables(variables)
                .build()
                .setVariables(variableValues);
        return expression.evaluate();
    }



    private void clearValues(List<CalcNode> calcNodes){
        calcNodes.forEach(this::clearValues);
    }

    private void clearValues(CalcNode parent) {
        if (parent == null) return;
        if (parent.getValue() == null) return;
        List<CalcNode> childs = parent.getCalcNodes();
        if (childs == null) childs = new ArrayList<>();

        for (CalcNode child : childs) {
            clearValues(child);
        }
        parent.setValue(null);
    }

    private void checkAndSaveResult(List<CalcNode> calcNodes, Map<String, Double> indicatorValueMap) {
        calcNodes.forEach(calcNode -> checkAndSaveResult(calcNode, indicatorValueMap));
    }

    private void checkAndSaveResult(CalcNode calcNode, Map<String, Double> indicatorValueMap) {
        Double prevValue = indicatorValueMap.get(calcNode.getName());
        if (prevValue == null) prevValue = 0d;
        Double currValue = calcNode.getValue();
        if (currValue == null) currValue = 0d;
        /* if type != const, accumulate value */
        if (!"const".equals(calcNode.getType())) {
            indicatorValueMap.put(calcNode.getName(), prevValue + currValue);
        } else {
            /* if type = const and value != prev value, rewrite value */
            if (!prevValue.equals(currValue)) {
                indicatorValueMap.put(calcNode.getName(), currValue);
            }
        }
    }
}
