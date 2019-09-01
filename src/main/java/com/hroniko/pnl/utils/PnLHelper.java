package com.hroniko.pnl.utils;

import com.hroniko.pnl.entity.catalog.Capex;
import com.hroniko.pnl.entity.catalog.Opex;
import com.hroniko.pnl.entity.nodes.CalcNode;
import com.hroniko.pnl.entity.price.PriceItem;
import com.hroniko.pnl.repo.CalcNodeRepository;
import com.hroniko.pnl.repo.CapexRepository;
import com.hroniko.pnl.repo.OpexRepository;
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

    /* move to Helper*/
    public List<CalcNode> getAllCalcNodes(){
        List<CalcNode> allCalcNodes = new ArrayList<>();
        calcNodeRepository.findAll().forEach(allCalcNodes::add);
        return allCalcNodes;
    }

    public List<CalcNodeSeries> getAllCalcNodeSeries(){
        return getAllCalcNodes().stream().map(CalcNodeSeries::new).collect(Collectors.toList());
    }

    /* move to Helper*/
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
    public List<PriceItem> getPriceItemsByQuote(Quote quote){
        List<PriceItem> allPriceItems = quote.getQuoteItem().stream()
                .map(PriceItem::new)
                .collect(Collectors.toList());
        return allPriceItems.stream()
                .filter(pi -> pi.getTotalMRC() + pi.getTotalNRC() > 0.0)
                .collect(Collectors.toList());
    }

}
