package com.hroniko.pnl.rest.service;

import com.hroniko.pnl.entity.catalog.Capex;
import com.hroniko.pnl.entity.catalog.Opex;
import com.hroniko.pnl.entity.nodes.CalcNode;
import com.hroniko.pnl.entity.other.PnLCalculationNode;
import com.hroniko.pnl.entity.other.PriceItem;
import com.hroniko.pnl.repo.CalcNodeRepository;
import com.hroniko.pnl.repo.CapexRepository;
import com.hroniko.pnl.repo.OpexRepository;
import com.hroniko.pnl.utils.PnLHelper;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PnLCalculationService {

    @Autowired
    CalcNodeRepository calcNodeRepository;

    @Autowired
    CapexRepository capexRepository;

    @Autowired
    OpexRepository opexRepository;

    @Autowired
    PnLHelper pnLHelper;


    /* move to Helper*/
    public List<CalcNode> getAllCalcNodes(){
        List<CalcNode> allCalcNodes = new ArrayList<>();
        calcNodeRepository.findAll().forEach(allCalcNodes::add);
        return allCalcNodes;
    }

    /* move to Helper*/
    public List<CalcNode> getFinalCalcNodes(){
        return getAllCalcNodes().stream()
                .filter(CalcNode::getFinal)
                .collect(Collectors.toList());
    }

    /* move to Helper*/
    public List<Capex> getAllCapex(){
        List<Capex> capexList = new ArrayList<>();
        capexRepository.findAll().forEach(capexList::add);
        return capexList;
    }

    /* move to Helper*/
    public List<Opex> getAllOpex(){
        List<Opex> opexList = new ArrayList<>();
        opexRepository.findAll().forEach(opexList::add);
        return opexList;
    }

    /* move to Helper*/
    private List<PriceItem> getPriceItemsByQuote(Quote quote){
        return quote.getQuoteItem().stream()
                .map(PriceItem::new)
                .collect(Collectors.toList());
    }

    public List<PnLCalculationNode> calculateByQuote(Quote quote){

        List<PriceItem> priceItems = getPriceItemsByQuote(quote);
        priceItems = priceItems.stream().filter(pi -> pi.getTotalMRC() + pi.getTotalNRC() > 0.0).collect(Collectors.toList());

        List<CalcNode> allCalcNodes = getAllCalcNodes();
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
                .filter(cn -> "Summary".equals(cn.getAttitudeToItems()))
                .forEach(calcNodeSummary -> {
                    String name = calcNodeSummary.getName();
                    if (indicatorValueMap.containsKey(name)) {
                        Double value = recalculateSummaryResult(allValueMap, calcNodeSummary);
                        allValueMap.put(name, value);
                        indicatorValueMap.put(name, value);
                    }
                });

        return indicatorValueMap.entrySet().stream()
                .map(x -> {
                    PnLCalculationNode node = new PnLCalculationNode();
                    node.setName(x.getKey());
                    node.setValue(x.getValue().toString());
                    return node;
                }).collect(Collectors.toList());
    }

    /* move to Helper*/
    private void enrichByPexCatalog(List<CalcNode> calcNodes, BigInteger offerId){
        List<Capex> capexList = getAllCapex();
        List<Opex> opexList = getAllOpex();

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
                    calcNode.setFormula(capexMap.get(offerId).toString());
                    calcNode.setValue(capexMap.get(offerId));
                });

        calcNodes.stream()
                .filter(calcNode -> "OPEOO".equals(calcNode.getName()))
                .forEach(calcNode -> {
                    calcNode.setFormula(opexMap.get(offerId).toString());
                    calcNode.setValue(opexMap.get(offerId));
                });
    }

    /* move to Helper*/
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



    public void recalculateValues(List<CalcNode> calcNodes){
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
        String formula = getFormulaFromCalcNode(parent);
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

    public Double recalculateSummaryResult(Map<String, Double> allValueMap, CalcNode calcNodeResult) {
        String formula = getFormulaFromCalcNode(calcNodeResult);

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

    private String getFormulaFromCalcNode(CalcNode calcNodeResult) {
        String formula = calcNodeResult.getFormula();
        if (formula.contains("=")) {
            String[] partFormula = formula.split("=");
            formula = partFormula[partFormula.length - 1];
        }
        return formula;
    }

    public void clearValues(List<CalcNode> calcNodes){
        calcNodes.forEach(this::clearValues);
    }

    public void clearValues(CalcNode parent) {
        if (parent == null) return;
        if (parent.getValue() == null) return;
        List<CalcNode> childs = parent.getCalcNodes();
        if (childs == null) childs = new ArrayList<>();

        for (CalcNode child : childs) {
            clearValues(child);
        }
        parent.setValue(null);
    }

    public void checkAndSaveResult(List<CalcNode> calcNodes, Map<String, Double> indicatorValueMap) {
        calcNodes.forEach(calcNode -> checkAndSaveResult(calcNode, indicatorValueMap));
    }

    public void checkAndSaveResult(CalcNode calcNode, Map<String, Double> indicatorValueMap) {
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
