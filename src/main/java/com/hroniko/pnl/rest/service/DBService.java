package com.hroniko.pnl.rest.service;

import com.hroniko.pnl.entity.catalog.Capex;
import com.hroniko.pnl.entity.catalog.Opex;
import com.hroniko.pnl.entity.nodes.CalcNode;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeConst;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeFinal;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeRefvar;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeVar;
import com.hroniko.pnl.entity.toms.CalculationStructure;
import com.hroniko.pnl.entity.toms.UpdateDBResult;
import com.hroniko.pnl.repo.CalcNodeRepository;
import com.hroniko.pnl.repo.CapexRepository;
import com.hroniko.pnl.repo.OpexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.hroniko.pnl.entity.constants.NodeType.*;
import static com.hroniko.pnl.entity.constants.NodeValueType.PERSENT;

@Service
public class DBService {

    @Autowired
    CalcNodeRepository calcNodeRepository;

    @Autowired
    CapexRepository capexRepository;

    @Autowired
    OpexRepository opexRepository;

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
                .map(this::convertCalcNodeTomsToCalcNode)
                .map(calcNode -> calcNode.setCurrencyCode(currency))
                .collect(Collectors.toList());
        if (allCalcNodes == null) return dbResult;

        /* create hierarchy calc nodes */
        allCalcNodes.forEach(calcNode -> {
                    String formula = getFormulaFromCalcNode(calcNode);
                    calcNode.setCalcNodes(allCalcNodes.stream()
                            .filter(childCalcNode -> formula.contains(childCalcNode.getName()) && !childCalcNode.getName().equals(calcNode.getName()))
                            .collect(Collectors.toList()));
                });
        /* clean up all calcnodes in database*/
        deleteAllCalcNodes();
        /* move all calc nodes to database */
        saveCalcNodes(allCalcNodes);

        /* get all calc nodes from database */
        List<CalcNode> dbAllCalcNodes = getAllCalcNodes();
        if (dbAllCalcNodes == null) return dbResult;

        /* get final calc nodes from database */
        List<CalcNode> dbFinalCalcNodes = getFinalCalcNodes(dbAllCalcNodes);

        /* update dbResult */
        dbResult.setCalcNodeTotalSize(dbAllCalcNodes.size())
                .setCalcNodeFinalSize(dbFinalCalcNodes.size())
                .setCalcNodeTotalNames(dbAllCalcNodes.stream().map(CalcNode::getName).collect(Collectors.toList()))
                .setCalcNodeFinalNames(dbFinalCalcNodes.stream().map(CalcNode::getName).collect(Collectors.toList()));


        List<com.hroniko.pnl.entity.toms.Opex> tomsOpexes = calculationStructure.getOpexes();
        List<Opex> opexes = tomsOpexes.stream()
                .map(this::convertOpexTomsToOpex)
                .collect(Collectors.toList());

        /* clean up all opex in database*/
        deleteAllOpex();

        /* move all calc nodes to database */
        saveOpexes(opexes);

        /* get all calc nodes from database */
        List<Opex> dbOpexes = getAllOpex();


        List<com.hroniko.pnl.entity.toms.Capex> tomsCapexes = calculationStructure.getCapexes();
        List<Capex> capexes = tomsCapexes.stream()
                .map(this::convertCapexTomsToCapex)
                .collect(Collectors.toList());

        /* clean up all capex in database*/
        deleteAllCapex();

        /* move all calc nodes to database */
        saveCapexes(capexes);

        /* get all calc nodes from database */
        List<Capex> dbCapexes = getAllCapex();

        /* update dbResult */
        dbResult.setOpexSize(dbOpexes.size())
                .setCapexSize(dbCapexes.size())
                .setOpexNames(dbOpexes.stream().map(Opex::getName).collect(Collectors.toList()))
                .setCapexNames(dbCapexes.stream().map(Capex::getName).collect(Collectors.toList()));

        return dbResult;
    }

    private CalcNode convertCalcNodeTomsToCalcNode(com.hroniko.pnl.entity.toms.CalcNode tCalcNode){
        CalcNode calcNode;

        if (tCalcNode.getFinal()){
            calcNode = new CalcNodeFinal();
        } else {
            String type = tCalcNode.getType();
            switch(type){
                case CONST:
                    calcNode = new CalcNodeConst();
                    break;
                case VAR:
                    calcNode = new CalcNodeVar();
                    break;
                case REFVAR:
                    calcNode = new CalcNodeRefvar();
                    break;
                default:
                    calcNode = new CalcNode();
            }
        }

        return calcNode
                .setName(tCalcNode.getName())
                .setCalcNodes(new ArrayList<>())
                .setFormula(tCalcNode.getFormula())
                .setType(tCalcNode.getType())
                .setFinal(tCalcNode.getFinal())
                .setValue(tCalcNode.getValue())
                .setValueType(tCalcNode.getValueType())
                .setAttitudeToItems(tCalcNode.getAttitudeToItems())
                .setPercent(PERSENT.equals(tCalcNode.getValueType()))
                .setMinValue(tCalcNode.getMinValue())
                .setMaxValue(tCalcNode.getMaxValue())
                .setDescription(tCalcNode.getDescription());
    }

    private Capex convertCapexTomsToCapex(com.hroniko.pnl.entity.toms.Capex tCapex){
        return new Capex()
                .setName(tCapex.getName())
                .setDescription(tCapex.getDescription())
                .setOfferingId(tCapex.getOfferingId())
                .setOfferingName(tCapex.getOfferingName())
                .setValue(tCapex.getValue());
    }

    private Opex convertOpexTomsToOpex(com.hroniko.pnl.entity.toms.Opex tOpex){
        return new Opex()
                .setName(tOpex.getName())
                .setDescription(tOpex.getDescription())
                .setOfferingId(tOpex.getOfferingId())
                .setOfferingName(tOpex.getOfferingName())
                .setValue(tOpex.getValue());
    }

    private String getFormulaFromCalcNode(CalcNode calcNodeResult) {
        String formula = calcNodeResult.getFormula();
        if (formula.contains("=")) {
            String[] partFormula = formula.split("=");
            formula = partFormula[partFormula.length - 1];
        }
        return formula;
    }

    private void deleteAllCalcNodes(){
        calcNodeRepository.deleteAll();
    }

    public void saveCalcNodes(List<CalcNode> calcNodes){
        calcNodes.forEach(calcNode -> calcNodeRepository.save(calcNode));
    }

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

    public void deleteAllCapex(){
        capexRepository.deleteAll();
    }

    public void saveCapexes(List<Capex> capexes){
        capexes.forEach(capexRepository::save);
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
}
