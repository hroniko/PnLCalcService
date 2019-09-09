package com.hroniko.pnl.entities.toms;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

public class CalculationStructure {
    private String toms;
    private Date date;
    private String currencyCode;
    private List<CalcNode> calcNodes;
    private List<OpexToms> opexes;
    private List<CapexToms> capexes;

    public CalculationStructure() {
    }

    public String getToms() {
        return toms;
    }

    public CalculationStructure setToms(String toms) {
        this.toms = toms;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public CalculationStructure setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CalculationStructure setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public List<CalcNode> getCalcNodes() {
        return calcNodes;
    }

    public CalculationStructure setCalcNodes(List<CalcNode> calcNodes) {
        this.calcNodes = calcNodes;
        return this;
    }

    public List<OpexToms> getOpexes() {
        return opexes;
    }

    public CalculationStructure setOpexes(List<OpexToms> opexes) {
        this.opexes = opexes;
        return this;
    }

    public List<CapexToms> getCapexes() {
        return capexes;
    }

    public CalculationStructure setCapexes(List<CapexToms> capexes) {
        this.capexes = capexes;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("toms", toms)
                .append("date", date)
                .append("currencyCode", currencyCode)
                .append("calcNodes", calcNodes)
                .append("opexes", opexes)
                .append("capexes", capexes)
                .toString();
    }

}
