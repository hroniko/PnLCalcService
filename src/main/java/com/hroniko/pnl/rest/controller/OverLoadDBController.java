package com.hroniko.pnl.rest.controller;

import com.hroniko.pnl.entity.catalog.Capex;
import com.hroniko.pnl.entity.catalog.Opex;
import com.hroniko.pnl.entity.nodes.CalcNode;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeConst;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeFinal;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeRefvar;
import com.hroniko.pnl.entity.nodes.additional.CalcNodeVar;
import com.hroniko.pnl.entity.toms.CalculationStructure;
import com.hroniko.pnl.rest.service.UpdateService;
import com.hroniko.pnl.rest.service.PnLCalculationService;
import com.hroniko.pnl.utils.PnLHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

import static com.hroniko.pnl.entity.constants.AttitudeToItems.*;
import static com.hroniko.pnl.entity.constants.FinalValue.*;
import static com.hroniko.pnl.entity.constants.NodeType.*;
import static com.hroniko.pnl.entity.constants.NodeValueType.*;

@RestController
@RequestMapping("/repo")
public class OverLoadDBController {

    @Autowired
    UpdateService updateService;

    @Autowired
    PnLCalculationService pnLCalculationService;

    @Autowired
    PnLHelper pnLHelper;

    private static final String EMPTY = "";

    /* only for test TODO remove it!*/
    @RequestMapping(value = {"/restart"}, method = RequestMethod.GET)
    public ResponseEntity restartDB(HttpServletRequest request){

        pnLHelper.clearRepository();

        CalcNode CH_index = new CalcNode()
                .setName("CH_index")
                .setFormula("0.007")
                .setType(CONST)
                .setFinal(NO)
                .setValueType(NATURAL)
                .setAttitudeToItems(SUMMARY)
                .setDescription("Churn index");

        CalcNode Capex_Depreciation_index = new CalcNode()
                .setName("Capex_Depreciation_index")
                .setFormula("60")
                .setType(CONST)
                .setFinal(NO)
                .setValueType(NATURAL)
                .setAttitudeToItems(SUMMARY)
                .setDescription(EMPTY);

        CalcNode DEXT = new CalcNodeRefvar()
                .setName("DEXT")
                .setFormula("0")
                .setType(REFVAR)
                .setFinal(NO)
                .setValueType(NATURAL)
                .setAttitudeToItems(EVERY)
                .setDescription("discountExcludingTax");

        CalcNode FUFU_index = new CalcNodeConst()
                .setName("FUFU_index")
                .setFormula("0.1")
                .setType(CONST)
                .setFinal(NO)
                .setValueType(NATURAL)
                .setAttitudeToItems(SUMMARY)
                .setDescription("Fust/Funtel Index");

        CalcNode IRCSLL_index = new CalcNodeConst()
                .setName("IRCSLL_index")
                .setFormula("0.28")
                .setType(CONST)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("IRCSLL_index");

        CalcNode OPC_index = new CalcNodeConst()
                .setName("OPC_index")
                .setFormula("0.3")
                .setType(CONST)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Comissionamento Index");

        CalcNode OPEOM = new CalcNodeConst()
                .setName("OPEOM")
                .setFormula("-29")
                .setType(CONST)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Operating Expenses(OpexToms Monthly)");

        CalcNode OPEOO = new CalcNodeRefvar()
                .setName("OPEOO")
                .setFormula("0")
                .setType(REFVAR)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Every")
                .setDescription("Operating Expenses(One time OpexToms)");

        CalcNode PDD_index = new CalcNodeConst()
                .setName("PDD_index")
                .setFormula("0.02")
                .setType(CONST)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("PDD_index");

        CalcNode PEDOTF = new CalcNodeConst()
                .setName("PEDOTF")
                .setFormula("1")
                .setType(CONST)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Operating Expenses (depend on the family)");

        CalcNode QDRN_index = new CalcNodeConst()
                .setName("QDRN_index")
                .setFormula("0.03")
                .setType(CONST)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Queda de Receita Index");

        CalcNode RCAPT = new CalcNodeRefvar()
                .setName("RCAPT")
                .setFormula("0")
                .setType(REFVAR)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Every")
                .setDescription("Recurrent CAPEX Total");

        CalcNode REPIC_index = new CalcNodeConst()
                .setName("REPIC_index")
                .setFormula("0.0925")
                .setType(CONST)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Recuperação Pis/Cofins Index");

        CalcNode RJ_index = new CalcNodeConst()
                .setName("RJ_index")
                .setFormula("0.042")
                .setType(CONST)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Reajuste Index");

        CalcNode VEXTMRC = new CalcNodeRefvar()
                .setName("VEXTMRC")
                .setFormula("5")
                .setType(REFVAR)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Every")
                .setDescription("valueExcludingTax MRC");

        CalcNode VEXTNRC = new CalcNodeRefvar()
                .setName("VEXTNRC")
                .setFormula("2")
                .setType(REFVAR)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Every")
                .setDescription("valueExcludingTax NRC");

        CalcNode WACC_index = new CalcNodeConst()
                .setName("WACC_index")
                .setFormula("0.1767")
                .setType(CONST)
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("WACC_index");

        /* -------------------------------------- */

        /* vars */
        CalcNode AFCF = new CalcNodeVar()
                .setName("AFCF")
                .setFormula("FCF")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Every")
                .setDescription("Accomulated Free Cash Flow");

        CalcNode CAPT = new CalcNodeFinal()
                .setName("CAPT")
                .setFormula("RCAPT * 24")
                .setType("var")
                .setFinal(true)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Total CAPEX");

        CalcNode CH = new CalcNodeVar()
                .setName("CH")
                .setFormula("CH = (NI - NNRC) * CH_index")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Churn");

        CalcNode Depreciation = new CalcNodeVar()
                .setName("Depreciation")
                .setFormula("RCAPT / Capex_Depreciation_index")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Depreciation");

        CalcNode EBIT = new CalcNodeVar()
                .setName("EBIT")
                .setFormula("EBIT = EBITDA - Depreciation")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Earnings Before Interest & Taxes");

        CalcNode EBITDA = new CalcNodeFinal()
                .setName("EBITDA")
                .setFormula("RNI - ROPT")
                .setType("var")
                .setFinal(true)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("EBITDA");

        CalcNode FCF = new CalcNodeVar()
                .setName("FCF")
                .setFormula("abs(EBITDA - IRCSLL - RCAPT)")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Free Cash Flow");

        CalcNode FUFU = new CalcNodeVar()
                .setName("FUFU")
                .setFormula("FUFU = (NI - NNRC) * FUFU_index")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Fust/Funtel = (NET Income -Net NRC) * Fust/Funtel Index");

        CalcNode IRCSLL = new CalcNodeVar()
                .setName("IRCSLL")
                .setFormula("(EBIT+PDDOP) * IRCSLL_index")
                .setType("var")
                .setFinal(false)
                .setValueType("Absolute")
                .setAttitudeToItems("Summary")
                .setDescription("IR/CSLL");

        CalcNode IRR = new CalcNodeFinal()
                .setName("IRR")
                .setFormula("IRR=(1+FCF*24)^(1/12)")
                .setType("var")
                .setFinal(true)
                .setValueType("Persent")
                .setAttitudeToItems("Summary")
                .setDescription("IRR");

        CalcNode MEBITDA = new CalcNodeFinal()
                .setName("MEBITDA")
                .setFormula("MEBITDA = (EBITDA /  RNI) * 100")
                .setType("var")
                .setFinal(true)
                .setValueType("Persent")
                .setAttitudeToItems("Summary")
                .setDescription("EBITDA Margin");

        CalcNode NI = new CalcNodeVar()
                .setName("NI")
                .setFormula("NI = NRRJ - QDRN")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Net income");

        CalcNode NMRC = new CalcNodeVar()
                .setName("NMRC")
                .setFormula("NMRC = VEXTMRC - DEXT")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Net MRC");

        CalcNode NMargin = new CalcNodeFinal()
                .setName("NMargin")
                .setFormula("(NProfit / RNI) * 100")
                .setType("var")
                .setFinal(true)
                .setValueType("Persent")
                .setAttitudeToItems("Summary")
                .setDescription("Net Margin");

        CalcNode NNRC = new CalcNodeVar()
                .setName("NNRC")
                .setFormula("NNRC = VEXTNRC")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Net NRC");

        CalcNode NPV = new CalcNodeFinal()
                .setName("NPV")
                .setFormula("FCF / ((1 + WACC)^1)")
                .setType("var")
                .setFinal(true)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("NPV Accumulated (Net Present Value)");

        CalcNode NProfit = new CalcNodeVar()
                .setName("NProfit")
                .setFormula("EBIT - IRCSLL")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Every")
                .setDescription("Net Profit");

        CalcNode NRRJ = new CalcNodeVar()
                .setName("NRRJ")
                .setFormula("NRRJ = NMRC + NNRC + RJN")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("(Net Revenue + Reajuste)");

        CalcNode OP = new CalcNodeVar()
                .setName("OP")
                .setFormula("OP = OPC + OPEOO +OPEOM - REPIC")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("OPEX");

        CalcNode OPC = new CalcNodeVar()
                .setName("OPC")
                .setFormula("OPC = NMRC * OPC_index")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Comissionamento");

        CalcNode OPT = new CalcNodeFinal()
                .setName("OPT")
                .setFormula("ROPT * 24")
                .setType("var")
                .setFinal(true)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Total OPEX");

        CalcNode PDDOP = new CalcNodeVar()
                .setName("PDDOP")
                .setFormula("PDDOP = NI * PDD_index")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("PDD OpexToms");

        CalcNode QDRN = new CalcNodeVar()
                .setName("QDRN")
                .setFormula("QDRN = QDRN_index * NRRJ")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Queda de Receita Net");

        CalcNode REPIC = new CalcNodeVar()
                .setName("REPIC")
                .setFormula("REPIC = OPEOO * REPIC_index")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Recuperação Pis/Cofins = Operating Expenses (depend on \n" +
                        "the family)  * Recuperação Pis/Cofins Index");

        CalcNode RJN = new CalcNodeVar()
                .setName("RJN")
                .setFormula("RJN = NMRC * RJ_index")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Reajuste Net");

        CalcNode RJOP = new CalcNodeVar()
                .setName("RJOP")
                .setFormula("RJOP = OP * RJ_index")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Reajuste OPEX");

        CalcNode RNI = new CalcNodeVar()
                .setName("RNI")
                .setFormula("RNI = NI - CH")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Recurrent NET Income");

        CalcNode ROPT = new CalcNodeVar()
                .setName("ROPT")
                .setFormula("ROPT = OP + RJOP + FUFU + PDDOP")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Recurrent OPEX");

        CalcNode TNI = new CalcNodeVar()
                .setName("TNI")
                .setFormula("RNI * 24")
                .setType("var")
                .setFinal(false)
                .setValueType("Natural")
                .setAttitudeToItems("Summary")
                .setDescription("Total NET Income");

        CalcNode WACC = new CalcNodeVar()
                .setName("WACC")
                .setFormula("(((1 + WACC_index)^(1/12))-1) * 100")
                .setType("var")
                .setFinal(false)
                .setValueType("Percent")
                .setAttitudeToItems("Summary")
                .setDescription("Weighted average cost of capital");

        /* Set childs */

        AFCF.addChild(FCF);
        CAPT.addChild(RCAPT);
        CH.addChild(NI).addChild(CH_index).addChild(NNRC);
        Depreciation.addChild(RCAPT).addChild(Capex_Depreciation_index);
        EBIT.addChild(EBITDA).addChild(Depreciation);
        EBITDA.addChild(RNI).addChild(ROPT);
        FCF.addChild(EBITDA).addChild(IRCSLL).addChild(RCAPT);
        FUFU.addChild(NI).addChild(NNRC).addChild(FUFU_index);
        IRCSLL.addChild(EBIT).addChild(PDDOP).addChild(IRCSLL_index);
        IRR.addChild(FCF);
        MEBITDA.addChilds(EBITDA, RNI);
        NI.addChilds(NRRJ, QDRN);
        NMRC.addChilds(VEXTMRC, DEXT);
        NMargin.addChilds(NProfit, RNI);
        NNRC.addChild(VEXTNRC);
        NPV.addChilds(FCF, WACC);
        NProfit.addChilds(EBIT, IRCSLL);
        NRRJ.addChilds(NNRC, RJN, NMRC);
        OP.addChilds(OPC, OPEOO, OPEOM, REPIC);
        OPC.addChilds(NMRC, OPC_index);
        OPT.addChild(ROPT);
        PDDOP.addChilds(NI, PDD_index);
        QDRN.addChilds(QDRN_index, NRRJ);
        REPIC.addChilds(OPEOO, REPIC_index);
        RJN.addChilds(NMRC, RJ_index);
        RJOP.addChilds(OP, RJ_index);
        RNI.addChilds(NI, CH);
        ROPT.addChilds(OP, RJOP, FUFU, PDDOP);
        TNI.addChild(RNI);
        WACC.addChild(WACC_index);

        /* add OpexToms & CapexToms*/

        Capex Fixed_Voice = new Capex()
                .setName("Fixed Voice")
                .setOfferingId(BigInteger.valueOf(9154817188851252832L))
                .setOfferingName("SmartVoice")
                .setValue(17.14)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Fixed_Voice);

        Capex MPLS_VPN = new Capex()
                .setName("MPLS VPN")
                .setOfferingId(BigInteger.valueOf(9153617201051733937L))
                .setOfferingName("MPLS VPN")
                .setValue(111.00)
                .setDescription("");
        pnLHelper.saveCapexes(MPLS_VPN);

        Capex Mobile_Plan_L = new Capex()
                .setName("Mobile Plan L")
                .setOfferingId(BigInteger.valueOf(9153369418151913693L))
                .setOfferingName("Mobile Plan Advanced")
                .setValue(0.00)
                .setDescription("");
        pnLHelper.saveCapexes(Mobile_Plan_L);

        Capex TV_Digital = new Capex()
                .setName("TV Digital")
                .setOfferingId(BigInteger.valueOf(9153368035751913598L))
                .setOfferingName("Digital TV Select")
                .setValue(11.42)
                .setDescription("");
        pnLHelper.saveCapexes(TV_Digital);

        Capex Fixed_Voice_Dect_Phone = new Capex()
                .setName("[Fixed Voice] Dect Phone")
                .setOfferingId(BigInteger.valueOf(9154817487551253196L))
                .setOfferingName("Polycom VVX 400")
                .setValue(14.28)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Fixed_Voice_Dect_Phone);

        Capex Fixed_Voice_Fixed_Line = new Capex()
                .setName("[Fixed Voice] Fixed Line")
                .setOfferingId(BigInteger.valueOf(9154817635851253352L))
                .setOfferingName("Polycom VVX 500")
                .setValue(14.28)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Fixed_Voice_Fixed_Line);

        Capex Fixed_Voice_Installation = new Capex()
                .setName("[Fixed Voice] Installation")
                .setOfferingId(BigInteger.valueOf(9153886315751441557L))
                .setOfferingName("Installation")
                .setValue(15.71)
                .setDescription("");
        pnLHelper.saveCapexes(Fixed_Voice_Installation);

        Capex MPLS_Cisco_Meraki_MR30H = new Capex()
                .setName("[MPLS] Cisco Meraki MR30H")
                .setOfferingId(BigInteger.valueOf(9153619006351734655L))
                .setOfferingName("Cisco Meraki MR30H")
                .setValue(187.00)
                .setDescription("");
        pnLHelper.saveCapexes(MPLS_Cisco_Meraki_MR30H);

        Capex MPLS_Redundancy_per_Device = new Capex()
                .setName("[MPLS] Redundancy (per Device)")
                .setOfferingId(BigInteger.valueOf(9153617317651734258L))
                .setOfferingName("Redundancy (per Device)")
                .setValue(7.50)
                .setDescription("");
        pnLHelper.saveCapexes(MPLS_Redundancy_per_Device);

        Capex Mobile_Plan_L_iPhone_6s = new Capex()
                .setName("[Mobile Plan L] iPhone 6s")
                .setOfferingId(BigInteger.valueOf(9153974491751872951L))
                .setOfferingName("Apple iPhone 6s")
                .setValue(2.85)
                .setDescription("");
        pnLHelper.saveCapexes(Mobile_Plan_L_iPhone_6s);

        Capex TV_Installation = new Capex()
                .setName("[TV] Installation")
                .setOfferingId(BigInteger.valueOf(9153835467651028687L))
                .setOfferingName("Installation")
                .setValue(14.28)
                .setDescription("");
        pnLHelper.saveCapexes(TV_Installation);

        Capex Voice_Auto_Attendant = new Capex()
                .setName("[Voice] Auto Attendant")
                .setOfferingId(BigInteger.valueOf(9154817452351253151L))
                .setOfferingName("Auto Attendant")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Voice_Auto_Attendant);

        Capex Voice_Call_Queuing = new Capex()
                .setName("[Voice] Call Queuing")
                .setOfferingId(BigInteger.valueOf(9154817459051253162L))
                .setOfferingName("Call Queuing")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Voice_Call_Queuing);

        Capex Voice_Call_Recording = new Capex()
                .setName("[Voice] Call Recording")
                .setOfferingId(BigInteger.valueOf(9154817472651253184L))
                .setOfferingName("Call Recording")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Voice_Call_Recording);

        Capex Voice_Multi_Conference = new Capex()
                .setName("[Voice] Multi Conference")
                .setOfferingId(BigInteger.valueOf(9154817283751252902L))
                .setOfferingName("Multi Conference")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Voice_Multi_Conference);

        Capex Voice_On_Hold_Messaging = new Capex()
                .setName("[Voice] On Hold Messaging")
                .setOfferingId(BigInteger.valueOf(9154817411751253121L))
                .setOfferingName("On Hold Messaging")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Voice_On_Hold_Messaging);

        Capex Voice_Reception_Console = new Capex()
                .setName("[Voice] Reception Console")
                .setOfferingId(BigInteger.valueOf(9154817466851253173L))
                .setOfferingName("Reception Console")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Voice_Reception_Console);

        Capex Voice_Video_Conferencing = new Capex()
                .setName("[Voice] Video Conferencing")
                .setOfferingId(BigInteger.valueOf(9154817331851252993L))
                .setOfferingName("Video Conferencing")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Voice_Video_Conferencing);

        Capex Voice_Voicemail_to_Email = new Capex()
                .setName("[Voice] Voicemail to Email")
                .setOfferingId(BigInteger.valueOf(9154817407751253102L))
                .setOfferingName("Voicemail to Email")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveCapexes(Voice_Voicemail_to_Email);


        /* OPEX */
        Opex o_Fixed_Voice = new Opex()
                .setName("[Fixed Voice]")
                .setOfferingId(BigInteger.valueOf(9154817188851252832L))
                .setOfferingName("SmartVoice")
                .setValue(27.14)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Fixed_Voice);

        Opex o_Fixed_Voice_Dect_Phone = new Opex()
                .setName("[Fixed Voice] Dect Phone")
                .setOfferingId(BigInteger.valueOf(9154817487551253196L))
                .setOfferingName("Polycom VVX 400")
                .setValue(25.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Fixed_Voice_Dect_Phone);

        Opex o_Fixed_Voice_Installation = new Opex()
                .setName("[Fixed Voice] Installation")
                .setOfferingId(BigInteger.valueOf(9153886315751441557L))
                .setOfferingName("Installation")
                .setValue(30.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Fixed_Voice_Installation);

        Opex o_Fixed_Voice_Fixed_Line = new Opex()
                .setName("[Fixed Voice] Fixed Line")
                .setOfferingId(BigInteger.valueOf(9154817635851253352L))
                .setOfferingName("Polycom VVX 500")
                .setValue(17.14)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Fixed_Voice_Fixed_Line);

        Opex o_MPLS_VPN = new Opex()
                .setName("[MPLS VPN]")
                .setOfferingId(BigInteger.valueOf(9153617201051733937L))
                .setOfferingName("MPLS VPN")
                .setValue(71.42)
                .setDescription("");
        pnLHelper.saveOpexes(o_MPLS_VPN);

        Opex o_MPLS_VPN_Cisco_Meraki_MR30H = new Opex()
                .setName("[MPLS] Cisco Meraki MR30H")
                .setOfferingId(BigInteger.valueOf(9153619006351734655L))
                .setOfferingName("Cisco Meraki MR30H")
                .setValue(71.42)
                .setDescription("");
        pnLHelper.saveOpexes(o_MPLS_VPN_Cisco_Meraki_MR30H);

        Opex o_Mobile_Plan_L = new Opex()
                .setName("[Mobile Plan L]")
                .setOfferingId(BigInteger.valueOf(9153369418151913693L))
                .setOfferingName("Mobile Plan Advanced")
                .setValue(35.71)
                .setDescription("");
        pnLHelper.saveOpexes(o_Mobile_Plan_L);

        Opex o_Mobile_Plan_L_iPhone_6s = new Opex()
                .setName("[Mobile Plan L]")
                .setOfferingId(BigInteger.valueOf(9153974491751872951L))
                .setOfferingName("Apple iPhone 6s")
                .setValue(1.42)
                .setDescription("");
        pnLHelper.saveOpexes(o_Mobile_Plan_L_iPhone_6s);

        Opex o_TV_Digital = new Opex()
                .setName("[TV Digital]")
                .setOfferingId(BigInteger.valueOf(9153368035751913598L))
                .setOfferingName("Digital TV Select")
                .setValue(14.28)
                .setDescription("");
        pnLHelper.saveOpexes(o_TV_Digital);

        Opex o_TV_Digital_Installation = new Opex()
                .setName("[TV Digital] Installation")
                .setOfferingId(BigInteger.valueOf(9153835467651028687L))
                .setOfferingName("Installation")
                .setValue(30.00)
                .setDescription("");
        pnLHelper.saveOpexes(o_TV_Digital_Installation);

        Opex o_TV_Digital_STB = new Opex()
                .setName("[TV Digital] STB")
                .setOfferingId(BigInteger.valueOf(9153835480251028693L))
                .setOfferingName("STB")
                .setValue(7.14)
                .setDescription("");
        pnLHelper.saveOpexes(o_TV_Digital_STB);

        Opex o_Voice_Auto_Attendant = new Opex()
                .setName("[Voice] Auto Attendant")
                .setOfferingId(BigInteger.valueOf(9154817452351253151L))
                .setOfferingName("Auto Attendant")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Voice_Auto_Attendant);

        Opex o_Voice_Call_Queuing = new Opex()
                .setName("[Voice] Call Queuing")
                .setOfferingId(BigInteger.valueOf(9154817459051253162L))
                .setOfferingName("Call Queuing")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Voice_Call_Queuing);

        Opex o_Voice_Call_Recording = new Opex()
                .setName("[Voice] Call Recording")
                .setOfferingId(BigInteger.valueOf(9154817472651253184L))
                .setOfferingName("Call Recordin")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Voice_Call_Recording);

        Opex o_Voice_Multi_Conference = new Opex()
                .setName("[Voice] Multi Conference")
                .setOfferingId(BigInteger.valueOf(9154817283751252902L))
                .setOfferingName("Multi Conference")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Voice_Multi_Conference);

        Opex o_Voice_On_Hold_Messaginge = new Opex()
                .setName("[Voice] On Hold Messaging")
                .setOfferingId(BigInteger.valueOf(9154817411751253121L))
                .setOfferingName("On Hold Messaging")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Voice_On_Hold_Messaginge);

        Opex o_Voice_Reception_Console = new Opex()
                .setName("[Voice] Reception Console")
                .setOfferingId(BigInteger.valueOf(9154817466851253173L))
                .setOfferingName("Reception Console")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Voice_Reception_Console);

        Opex o_Voice_Video_Conferencing = new Opex()
                .setName("[Voice] Video Conferencing")
                .setOfferingId(BigInteger.valueOf(9154817331851252993L))
                .setOfferingName("Video Conferencing")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Voice_Video_Conferencing);

        Opex o_Voicemail_to_Email= new Opex()
                .setName("[Voice] Voicemail to Email")
                .setOfferingId(BigInteger.valueOf(9154817407751253102L))
                .setOfferingName("Voicemail to Email")
                .setValue(0.00)
                .setDescription("Shaw Voice");
        pnLHelper.saveOpexes(o_Voicemail_to_Email);

        /*    */

        pnLHelper.saveCalcNodes(CH_index,
                Capex_Depreciation_index,
                DEXT,
                FUFU_index,
                IRCSLL_index,
                OPC_index,
                OPEOM,
                OPEOO,
                PDD_index,
                PEDOTF,
                QDRN_index,
                RCAPT,
                REPIC_index,
                RJ_index,
                VEXTMRC,
                VEXTNRC,
                WACC_index,
                AFCF,
                CAPT,
                CH,
                Depreciation,
                EBIT,
                EBITDA,
                FCF,
                FUFU,
                IRCSLL,
                IRR,
                MEBITDA,
                NI,
                NMRC,
                NMargin,
                NNRC,
                NPV,
                NProfit,
                NRRJ,
                OP,
                OPC,
                OPT,
                PDDOP,
                QDRN,
                REPIC,
                RJN,
                RJOP,
                RNI,
                ROPT,
                TNI,
                WACC
                );

        List<CalcNode> finalCalcNodes = pnLHelper.getFinalCalcNodes();
        return new ResponseEntity<>(finalCalcNodes, HttpStatus.OK);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public ResponseEntity setCalculationStructureToDB(@RequestBody CalculationStructure calculationStructure){
        return new ResponseEntity<>(updateService.setCalculationStructureToDB(calculationStructure), HttpStatus.OK);
    }
}
