package com.hroniko.pnl.entity;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class CalcNode {
    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private String name;

    @Relationship(type = "REFERENCE", direction = Relationship.DIRECTION)
    private List<CalcNode> calcNodes;

    private String formula;
    private String type;
    private Boolean isFinal;
    private Double value;
    private String valueType;
    private String attitudeToItems;
    private String minValue;
    private String maxValue;

    public CalcNode() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */

    public Long getId() {
        return id;
    }

    public CalcNode setId(Long id) {
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

    public void setValue(Double value) {
        this.value = value;
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

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public CalcNode addChild(CalcNode calcNode) {
        if (calcNodes == null) {
            calcNodes = new ArrayList<>();
        }
        if (!calcNodes.contains(calcNode))
            calcNodes.add(calcNode);
        return this;
    }

    public CalcNode addChilds(CalcNode ... calcNodes) {
        for (CalcNode calcNode : calcNodes){
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
                .append("valueType", valueType)
                .append("attitudeToItems", attitudeToItems)
                .append("minValue", minValue)
                .append("maxValue", maxValue)
                .toString();
    }
}
