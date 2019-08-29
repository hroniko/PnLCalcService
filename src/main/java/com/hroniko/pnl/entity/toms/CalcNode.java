package com.hroniko.pnl.entity.toms;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class CalcNode {
    private BigInteger id;
    private String description;
    private String name;
    private List<CalcNode> calcNodes;
    private List<String> calcNodeNames;
    private String formula;
    private String type;
    private Boolean isFinal;
    private Double value;
    private String valueType;
    private String attitudeToItems;
    private String minValue;
    private String maxValue;
    private BigInteger refvarAttrId;

    public BigInteger getId() {
        return id;
    }

    public CalcNode setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CalcNode setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public CalcNode setName(String name) {
        this.name = name;
        return this;
    }

    public List<CalcNode> getCalcNodes() {
        return calcNodes;
    }

    public CalcNode setCalcNodes(List<CalcNode> calcNodes) {
        this.calcNodes = calcNodes;
        return this;
    }

    public List<String> getCalcNodeNames() {
        return calcNodeNames;
    }

    public CalcNode setCalcNodeNames(List<String> calcNodeNames) {
        this.calcNodeNames = calcNodeNames;
        return this;
    }

    public String getFormula() {
        return formula;
    }

    public CalcNode setFormula(String formula) {
        this.formula = formula;
        return this;
    }

    public String getType() {
        return type;
    }

    public CalcNode setType(String type) {
        this.type = type;
        return this;
    }

    public Boolean getFinal() {
        return isFinal;
    }

    public CalcNode setFinal(Boolean aFinal) {
        isFinal = aFinal;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public CalcNode setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getValueType() {
        return valueType;
    }

    public CalcNode setValueType(String valueType) {
        this.valueType = valueType;
        return this;
    }

    public String getAttitudeToItems() {
        return attitudeToItems;
    }

    public CalcNode setAttitudeToItems(String attitudeToItems) {
        this.attitudeToItems = attitudeToItems;
        return this;
    }

    public String getMinValue() {
        return minValue;
    }

    public CalcNode setMinValue(String minValue) {
        this.minValue = minValue;
        return this;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public CalcNode setMaxValue(String maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public BigInteger getRefvarAttrId() {
        return refvarAttrId;
    }

    public CalcNode setRefvarAttrId(BigInteger refvarAttrId) {
        this.refvarAttrId = refvarAttrId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", name)
                .append("calcNodeNames", calcNodeNames)
                .append("formula", formula)
                .append("type", type)
                .append("isFinal", isFinal)
                .append("value", value)
                .append("valueType", valueType)
                .append("attitudeToItems", attitudeToItems)
                .append("minValue", minValue)
                .append("maxValue", maxValue)
                .append("refvarAttrId", refvarAttrId)
                .toString();
    }
}
