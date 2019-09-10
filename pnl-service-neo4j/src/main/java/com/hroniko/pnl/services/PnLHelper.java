package com.hroniko.pnl.services;

import com.hroniko.pnl.entities.catalog.Capex;
import com.hroniko.pnl.entities.catalog.Opex;
import com.hroniko.pnl.entities.nodes.CalcNode;
import com.hroniko.pnl.entities.nodes.CalcNodeSeries;
import com.hroniko.pnl.entities.price.PriceItem;
import com.hroniko.pnl.repositories.CalcNodeRepository;
import com.hroniko.pnl.repositories.CapexRepository;
import com.hroniko.pnl.repositories.OpexRepository;

import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PnLHelper {

    final
    CalcNodeRepository calcNodeRepository;

    final
    CapexRepository capexRepository;

    final
    OpexRepository opexRepository;

    public PnLHelper(CalcNodeRepository calcNodeRepository, CapexRepository capexRepository, OpexRepository opexRepository) {
        this.calcNodeRepository = calcNodeRepository;
        this.capexRepository = capexRepository;
        this.opexRepository = opexRepository;
    }

    public List<CalcNode> getAllCalcNodes(){
        List<CalcNode> allCalcNodes = new ArrayList<>();
        calcNodeRepository.findAll().forEach(allCalcNodes::add);
        return allCalcNodes;
    }

    public List<CalcNodeSeries> getAllCalcNodeSeries(){
        return getAllCalcNodes().stream().map(CalcNodeSeries::new).collect(Collectors.toList());
    }

    public List<CalcNode> getFinalCalcNodes(){
        return getAllCalcNodes().stream()
                .filter(CalcNode::getFinal)
                .collect(Collectors.toList());
    }

    public List<CalcNodeSeries> getFinalCalcNodeSeries(){
        return getAllCalcNodeSeries().stream()
                .filter(CalcNodeSeries::getFinal)
                .collect(Collectors.toList());
    }

    public List<Capex> getAllCapex(){
        List<Capex> capexList = new ArrayList<>();
        capexRepository.findAll().forEach(capexList::add);
        return capexList;
    }

    public List<Opex> getAllOpex(){
        List<Opex> opexList = new ArrayList<>();
        opexRepository.findAll().forEach(opexList::add);
        return opexList;
    }

    public List<PriceItem> getPriceItemsByQuote(Quote quote){
        List<PriceItem> allPriceItems = quote.getQuoteItem().stream()
                .map(PriceItem::new)
                .filter(pi -> pi.getTotalMRC() + pi.getTotalNRC() > 0.0)
                .collect(Collectors.toList());
        return allPriceItems;
    }

    public void deleteAllCalcNodes(){
        calcNodeRepository.deleteAll();
    }

    public void saveCalcNodes(List<CalcNode> calcNodes){
        calcNodes.forEach(calcNode -> calcNodeRepository.save(calcNode));
    }

    public void saveCalcNodes(CalcNode ... calcNodes){
        for (CalcNode calcNode : calcNodes) {
            calcNodeRepository.save(calcNode);
        }
    }

    public List<CalcNode> getFinalCalcNodes(List<CalcNode> allCalcNodes){
        return allCalcNodes.stream()
                .filter(CalcNode::getFinal)
                .collect(Collectors.toList());
    }

    public void deleteAllOpex(){
        opexRepository.deleteAll();
    }

    public void saveOpexes(List<Opex> opexes){
        opexes.forEach(opexRepository::save);
    }

    public void saveOpexes(Opex ... opexes){
        for (Opex opex : opexes) {
            opexRepository.save(opex);
        }
    }

    public void deleteAllCapex(){
        capexRepository.deleteAll();
    }

    public void clearRepository(){
        calcNodeRepository.deleteAll();
        opexRepository.deleteAll();
        capexRepository.deleteAll();
    }

    public void saveCapexes(List<Capex> capexes){
        capexes.forEach(capexRepository::save);
    }

    public void saveCapexes(Capex ... capexes){
        for (Capex capex : capexes) {
            capexRepository.save(capex);
        }
    }

    public String getFormulaFromCalcNode(CalcNode calcNodeResult) {
        return getFormulaFromCalcNode(calcNodeResult.getFormula());
    }

    public String getFormulaFromCalcNode(CalcNodeSeries calcNodeResult) {
        return getFormulaFromCalcNode(calcNodeResult.getFormula());
    }

    public String getFormulaFromCalcNode(String formula){
        if (formula.contains("=")) {
            String[] partFormula = formula.split("=");
            formula = partFormula[partFormula.length - 1];
        }
        return formula;
    }

}
