package com.hroniko.pnl.utils.converters;

import com.hroniko.pnl.entity.catalog.Capex;
import com.hroniko.pnl.entity.catalog.Opex;
import com.hroniko.pnl.entity.nodes.CalcNode;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeConst;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeFinal;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeRefvar;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeVar;
import com.hroniko.pnl.entity.toms.CapexToms;
import com.hroniko.pnl.entity.toms.OpexToms;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.hroniko.pnl.entity.constants.NodeType.*;
import static com.hroniko.pnl.entity.constants.NodeValueType.PERSENT;

@Service
public class TomsConverter {

    public CalcNode convertCalcNodeTomsToCalcNode(com.hroniko.pnl.entity.toms.CalcNode tCalcNode){
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

    public Capex convertCapexTomsToCapex(CapexToms tCapex){
        return new Capex()
                .setName(tCapex.getName())
                .setDescription(tCapex.getDescription())
                .setOfferingId(tCapex.getOfferingId())
                .setOfferingName(tCapex.getOfferingName())
                .setValue(tCapex.getValue());
    }

    public Opex convertOpexTomsToOpex(OpexToms tOpex){
        return new Opex()
                .setName(tOpex.getName())
                .setDescription(tOpex.getDescription())
                .setOfferingId(tOpex.getOfferingId())
                .setOfferingName(tOpex.getOfferingName())
                .setValue(tOpex.getValue());
    }
}
