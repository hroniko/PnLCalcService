package com.hroniko.pnl.entities.results;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PnLCalculationNodeResult {
    private String name;
    private String shortName;
    private String value;
    private String currencyCode;
    private boolean isPercent;
    private String minValue;
    private String maxValue;

    public String getName() {
        return name;
    }

    public PnLCalculationNodeResult setName(String name) {
        this.name = name;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public PnLCalculationNodeResult setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getValue() {
        return value;
    }

    public PnLCalculationNodeResult setValue(String value) {
        this.value = value;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public PnLCalculationNodeResult setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public boolean isPercent() {
        return isPercent;
    }

    public PnLCalculationNodeResult setPercent(boolean percent) {
        isPercent = percent;
        return this;
    }

    public String getMinValue() {
        return minValue;
    }

    public PnLCalculationNodeResult setMinValue(String minValue) {
        this.minValue = minValue;
        return this;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public PnLCalculationNodeResult setMaxValue(String maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("name", name)
                .append("shortName", shortName)
                .append("value", value)
                .append("currencyCode", currencyCode)
                .append("isPercent", isPercent)
                .append("minValue", minValue)
                .append("maxValue", maxValue)
                .toString();
    }
}
