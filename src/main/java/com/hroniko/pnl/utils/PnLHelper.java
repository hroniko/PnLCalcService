package com.hroniko.pnl.utils;

import com.hroniko.pnl.entity.catalog.Capex;
import com.hroniko.pnl.entity.catalog.Opex;
import com.hroniko.pnl.entity.nodes.CalcNode;
import com.hroniko.pnl.entity.price.PriceItem;
import com.hroniko.pnl.repo.CalcNodeRepository;
import com.hroniko.pnl.repo.CapexRepository;
import com.hroniko.pnl.repo.OpexRepository;
import com.hroniko.pnl.utils.entity.CalcNodeSeries;
import com.netcracker.tbapi.datamodel.tmf.quote.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PnLHelper {

    @Autowired
    CalcNodeRepository calcNodeRepository;

    @Autowired
    CapexRepository capexRepository;

    @Autowired
    OpexRepository opexRepository;

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
                .collect(Collectors.toList());
        return allPriceItems.stream()
                .filter(pi -> pi.getTotalMRC() + pi.getTotalNRC() > 0.0)
                .collect(Collectors.toList());
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

}
