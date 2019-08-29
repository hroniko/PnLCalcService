package com.hroniko.pnl.entity.toms;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

public class UpdateDBResult {

    private String toms;
    private Date date;
    private Integer calcNodeTotalSize;
    private Integer calcNodeFinalSize;
    private Integer opexSize;
    private Integer capexSize;
    private List<String> calcNodeTotalNames;
    private List<String> calcNodeFinalNames;
    private List<String> opexNames;
    private List<String> capexNames;

    public String getToms() {
        return toms;
    }

    public UpdateDBResult setToms(String toms) {
        this.toms = toms;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public UpdateDBResult setDate(Date date) {
        this.date = date;
        return this;
    }

    public Integer getCalcNodeTotalSize() {
        return calcNodeTotalSize;
    }

    public UpdateDBResult setCalcNodeTotalSize(Integer calcNodeTotalSize) {
        this.calcNodeTotalSize = calcNodeTotalSize;
        return this;
    }

    public Integer getCalcNodeFinalSize() {
        return calcNodeFinalSize;
    }

    public UpdateDBResult setCalcNodeFinalSize(Integer calcNodeFinalSize) {
        this.calcNodeFinalSize = calcNodeFinalSize;
        return this;
    }

    public Integer getOpexSize() {
        return opexSize;
    }

    public UpdateDBResult setOpexSize(Integer opexSize) {
        this.opexSize = opexSize;
        return this;
    }

    public Integer getCapexSize() {
        return capexSize;
    }

    public UpdateDBResult setCapexSize(Integer capexSize) {
        this.capexSize = capexSize;
        return this;
    }

    public List<String> getCalcNodeTotalNames() {
        return calcNodeTotalNames;
    }

    public UpdateDBResult setCalcNodeTotalNames(List<String> calcNodeTotalNames) {
        this.calcNodeTotalNames = calcNodeTotalNames;
        return this;
    }

    public List<String> getCalcNodeFinalNames() {
        return calcNodeFinalNames;
    }

    public UpdateDBResult setCalcNodeFinalNames(List<String> calcNodeFinalNames) {
        this.calcNodeFinalNames = calcNodeFinalNames;
        return this;
    }

    public List<String> getOpexNames() {
        return opexNames;
    }

    public UpdateDBResult setOpexNames(List<String> opexNames) {
        this.opexNames = opexNames;
        return this;
    }

    public List<String> getCapexNames() {
        return capexNames;
    }

    public UpdateDBResult setCapexNames(List<String> capexNames) {
        this.capexNames = capexNames;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("toms", toms)
                .append("date", date)
                .append("calcNodeTotalSize", calcNodeTotalSize)
                .append("calcNodeFinalSize", calcNodeFinalSize)
                .append("opexSize", opexSize)
                .append("capexSize", capexSize)
                .append("calcNodeTotalNames", calcNodeTotalNames)
                .append("calcNodeFinalNames", calcNodeFinalNames)
                .append("opexNames", opexNames)
                .append("capexNames", capexNames)
                .toString();
    }
}
