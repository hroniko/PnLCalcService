package com.hroniko.pnl.entities.nodes;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndex;

import com.arangodb.springframework.annotation.Relations;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Document("calcnodes")
@HashIndex(fields = { "id" })
public class CalcNode {
    @Id
    private String id;

    private String description;
    private String name;

    @Relations(edges = ChildOf.class, direction = Relations.Direction.INBOUND)
    private List<CalcNode> calcNodes;

    private String formula;
    private String type;
    private Boolean isFinal;
    private Double value;
    private String valueType;
    private String attitudeToItems;
    private String minValue;
    private String maxValue;
    private String currencyCode;
    private boolean isPercent;

    public CalcNode() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */

    public String getId() {
        return id;
    }

    public CalcNode setId(String id) {
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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CalcNode setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public boolean isPercent() {
        return isPercent;
    }

    public CalcNode setPercent(boolean percent) {
        isPercent = percent;
        return this;
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
                .append("currencyCode", currencyCode)
                .append("isPercent", isPercent)
                .append("minValue", minValue)
                .append("maxValue", maxValue)
                .toString();
    }
}
