package com.hroniko.pnl.rest.service;

import com.hroniko.pnl.entity.catalog.Capex;
import com.hroniko.pnl.entity.catalog.Opex;
import com.hroniko.pnl.entity.nodes.CalcNode;
import com.hroniko.pnl.entity.toms.CalculationStructure;
import com.hroniko.pnl.entity.toms.CapexToms;
import com.hroniko.pnl.entity.toms.OpexToms;
import com.hroniko.pnl.entity.toms.UpdateDBResult;
import com.hroniko.pnl.utils.PnLHelper;
import com.hroniko.pnl.utils.converters.TomsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpdateService {

    @Autowired
    PnLHelper pnLHelper;

    @Autowired
    TomsConverter tomsConverter;

    public UpdateDBResult setCalculationStructureToDB(CalculationStructure calculationStructure){
        /* init result */
        UpdateDBResult dbResult = new UpdateDBResult()
                .setToms(calculationStructure.getToms())
                .setDate(calculationStructure.getDate())
                .setCalcNodeTotalSize(0)
                .setCalcNodeFinalSize(0)
                .setOpexSize(0)
                .setCapexSize(0)
                .setCalcNodeTotalNames(new ArrayList<>())
                .setCalcNodeFinalNames(new ArrayList<>())
                .setOpexNames(new ArrayList<>())
                .setCapexNames(new ArrayList<>());

        List<com.hroniko.pnl.entity.toms.CalcNode> tomsCalcNodes = calculationStructure.getCalcNodes();
        if (tomsCalcNodes == null) return dbResult;

        String currency = calculationStructure.getCurrencyCode();
        /* create flat calc nodes without hierarchy*/
        List<CalcNode> allCalcNodes = tomsCalcNodes.stream()
                .map(tomsConverter::convertCalcNodeTomsToCalcNode)
                .map(calcNode -> calcNode.setCurrencyCode(currency))
                .collect(Collectors.toList());
        if (allCalcNodes == null) return dbResult;

        /* create hierarchy calc nodes */
        tomsCalcNodes.forEach(tomsCalcNode -> {
                    String parentName = tomsCalcNode.getName();
                    List<String> childNames = tomsCalcNode.getCalcNodeNames();
                    if (childNames == null || childNames.isEmpty()) return;
                    CalcNode parentNode = allCalcNodes.stream().filter(pn -> parentName.equals(pn.getName())).findFirst().orElse(null);
                    if (parentNode == null) return;
                    List<CalcNode> childNodes = allCalcNodes.stream().filter(cn -> childNames.contains(cn.getName())).collect(Collectors.toList());
                    parentNode.setCalcNodes(childNodes);
                });

        /* clean up all calcnodes in database*/
        pnLHelper.deleteAllCalcNodes();
        /* move all calc nodes to database */
        pnLHelper.saveCalcNodes(allCalcNodes);

        /* get all calc nodes from database */
        List<CalcNode> dbAllCalcNodes = pnLHelper.getAllCalcNodes();
        if (dbAllCalcNodes == null) return dbResult;

        /* get final calc nodes from database */
        List<CalcNode> dbFinalCalcNodes = pnLHelper.getFinalCalcNodes(dbAllCalcNodes);

        /* update dbResult */
        dbResult.setCalcNodeTotalSize(dbAllCalcNodes.size())
                .setCalcNodeFinalSize(dbFinalCalcNodes.size())
                .setCalcNodeTotalNames(dbAllCalcNodes.stream().map(CalcNode::getName).collect(Collectors.toList()))
                .setCalcNodeFinalNames(dbFinalCalcNodes.stream().map(CalcNode::getName).collect(Collectors.toList()));


        List<OpexToms> tomsOpexes = calculationStructure.getOpexes();
        List<Opex> opexes = tomsOpexes.stream()
                .map(tomsConverter::convertOpexTomsToOpex)
                .collect(Collectors.toList());

        /* clean up all opex in database*/
        pnLHelper.deleteAllOpex();

        /* move all calc nodes to database */
        pnLHelper.saveOpexes(opexes);

        /* get all calc nodes from database */
        List<Opex> dbOpexes = pnLHelper.getAllOpex();


        List<CapexToms> tomsCapexes = calculationStructure.getCapexes();
        List<Capex> capexes = tomsCapexes.stream()
                .map(tomsConverter::convertCapexTomsToCapex)
                .collect(Collectors.toList());

        /* clean up all capex in database*/
        pnLHelper.deleteAllCapex();

        /* move all calc nodes to database */
        pnLHelper.saveCapexes(capexes);

        /* get all calc nodes from database */
        List<Capex> dbCapexes = pnLHelper.getAllCapex();

        /* update dbResult */
        dbResult.setOpexSize(dbOpexes.size())
                .setCapexSize(dbCapexes.size())
                .setOpexNames(dbOpexes.stream().map(Opex::getName).collect(Collectors.toList()))
                .setCapexNames(dbCapexes.stream().map(Capex::getName).collect(Collectors.toList()));

        return dbResult;
    }

}
