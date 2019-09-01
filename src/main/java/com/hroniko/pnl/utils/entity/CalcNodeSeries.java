package com.hroniko.pnl.utils.entity;


import com.hroniko.pnl.entity.nodes.CalcNode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalcNodeSeries {
    private Long id;

    private String description;
    private String name;

    private List<CalcNodeSeries> calcNodes;

    private String formula;
    private String type;
    private Boolean isFinal;
    private Double value;
    private List<Double> values;
    private String valueType;
    private String attitudeToItems;
    private String minValue;
    private String maxValue;
    private String currencyCode;
    private boolean isPercent;

    public CalcNodeSeries(CalcNode calcNode) {
        this.id = calcNode.getId();
        this.description = calcNode.getDescription();
        this.name = calcNode.getName();
        this.calcNodes = calcNode.getCalcNodes() == null ? null : calcNode.getCalcNodes().stream().map(CalcNodeSeries::new).collect(Collectors.toList());
        this.formula = calcNode.getFormula();
        this.type = calcNode.getType();
        this.isFinal = calcNode.getFinal();
        this.value = calcNode.getValue();
        this.values = new ArrayList<>();
        this.valueType = calcNode.getValueType();
        this.attitudeToItems = calcNode.getAttitudeToItems();
        this.minValue = calcNode.getMinValue();
        this.maxValue = calcNode.getMaxValue();
        this.currencyCode = calcNode.getCurrencyCode();
        this.isPercent = calcNode.isPercent();
    }

    public Long getId() {
        return id;
    }

    public CalcNodeSeries setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CalcNodeSeries setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public CalcNodeSeries setName(String name) {
        this.name = name;
        return this;
    }

    public List<CalcNodeSeries> getCalcNodes() {
        return calcNodes;
    }

    public CalcNodeSeries setCalcNodes(List<CalcNodeSeries> calcNodes) {
        this.calcNodes = calcNodes;
        return this;
    }

    public String getFormula() {
        return formula;
    }

    public CalcNodeSeries setFormula(String formula) {
        this.formula = formula;
        return this;
    }

    public String getType() {
        return type;
    }

    public CalcNodeSeries setType(String type) {
        this.type = type;
        return this;
    }

    public Boolean getFinal() {
        return isFinal;
    }

    public CalcNodeSeries setFinal(Boolean aFinal) {
        isFinal = aFinal;
        return this;
    }

    public Double getValueFromValues(Integer pos) {
        if (values != null && values.size() > pos)
            return values.get(pos);
        return value;
    }

    public CalcNodeSeries addValueToValues(Double value) {
        if (this.values == null)
            values = new ArrayList<>();
        values.add(value);
        return this;
    }

    public List<Double> getValues() {
        return values;
    }

    public CalcNodeSeries setValues(List<Double> values) {
        this.values = values;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public CalcNodeSeries setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getValueType() {
        return valueType;
    }

    public CalcNodeSeries setValueType(String valueType) {
        this.valueType = valueType;
        return this;
    }

    public String getAttitudeToItems() {
        return attitudeToItems;
    }

    public CalcNodeSeries setAttitudeToItems(String attitudeToItems) {
        this.attitudeToItems = attitudeToItems;
        return this;
    }

    public String getMinValue() {
        return minValue;
    }

    public CalcNodeSeries setMinValue(String minValue) {
        this.minValue = minValue;
        return this;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public CalcNodeSeries setMaxValue(String maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CalcNodeSeries setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public boolean isPercent() {
        return isPercent;
    }

    public CalcNodeSeries setPercent(boolean percent) {
        isPercent = percent;
        return this;
    }

    public CalcNodeSeries addChild(CalcNodeSeries calcNode) {
        if (calcNodes == null) {
            calcNodes = new ArrayList<>();
        }
        if (!calcNodes.contains(calcNode))
            calcNodes.add(calcNode);
        return this;
    }

    public CalcNodeSeries addChilds(CalcNodeSeries... calcNodes) {
        for (CalcNodeSeries calcNode : calcNodes){
            addChild(calcNode);
        }
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", name)
                .append("calcNodes", calcNodes)
                .append("formula", formula)
                .append("type", type)
                .append("isFinal", isFinal)
                .append("value", value)
                .append("values", values)
                .append("valueType", valueType)
                .append("attitudeToItems", attitudeToItems)
                .append("currencyCode", currencyCode)
                .append("isPercent", isPercent)
                .append("minValue", minValue)
                .append("maxValue", maxValue)
                .toString();
    }
}
