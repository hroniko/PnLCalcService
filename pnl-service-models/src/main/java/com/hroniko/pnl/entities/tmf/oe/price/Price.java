package com.hroniko.pnl.entities.tmf.oe.price;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Provides all amounts (tax included, duty free, tax rate), used currency and percentage to apply for Price Alteration.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String taxIncludedAmount;
    private String dutyFreeAmount;
    private Float taxRate;
    private Float percentage;
    private Boolean overridden;
    private String overrideType;
    private String priceValueRef;
    private String valueBasePriceExcludingTax;
    private String valueBasePriceExcludingTaxRounded;
    private String valueBasePriceIncludingTax;
    private String valueBasePriceIncludingTaxRounded;
    private String valueExcludingTax;
    private String valueExcludingTaxRounded;
    private String valueIncludingTax;
    private String valueIncludingTaxRounded;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public String getTaxIncludedAmount() {
        return taxIncludedAmount;
    }

    public void setTaxIncludedAmount(String taxIncludedAmount) {
        this.taxIncludedAmount = taxIncludedAmount;
    }

    public String getDutyFreeAmount() {
        return dutyFreeAmount;
    }

    public void setDutyFreeAmount(String dutyFreeAmount) {
        this.dutyFreeAmount = dutyFreeAmount;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public Boolean getOverridden() {
        return overridden;
    }

    public void setOverridden(Boolean overridden) {
        this.overridden = overridden;
    }

    public String getOverrideType() {
        return overrideType;
    }

    public void setOverrideType(String overrideType) {
        this.overrideType = overrideType;
    }

    public String getPriceValueRef() {
        return priceValueRef;
    }

    public void setPriceValueRef(String priceValueRef) {
        this.priceValueRef = priceValueRef;
    }

    public String getValueBasePriceExcludingTax() {
        return valueBasePriceExcludingTax;
    }

    public void setValueBasePriceExcludingTax(String valueBasePriceExcludingTax) {
        this.valueBasePriceExcludingTax = valueBasePriceExcludingTax;
    }

    public String getValueBasePriceExcludingTaxRounded() {
        return valueBasePriceExcludingTaxRounded;
    }

    public void setValueBasePriceExcludingTaxRounded(String valueBasePriceExcludingTaxRounded) {
        this.valueBasePriceExcludingTaxRounded = valueBasePriceExcludingTaxRounded;
    }

    public String getValueBasePriceIncludingTax() {
        return valueBasePriceIncludingTax;
    }

    public void setValueBasePriceIncludingTax(String valueBasePriceIncludingTax) {
        this.valueBasePriceIncludingTax = valueBasePriceIncludingTax;
    }

    public String getValueBasePriceIncludingTaxRounded() {
        return valueBasePriceIncludingTaxRounded;
    }

    public void setValueBasePriceIncludingTaxRounded(String valueBasePriceIncludingTaxRounded) {
        this.valueBasePriceIncludingTaxRounded = valueBasePriceIncludingTaxRounded;
    }

    public String getValueExcludingTax() {
        return valueExcludingTax;
    }

    public void setValueExcludingTax(String valueExcludingTax) {
        this.valueExcludingTax = valueExcludingTax;
    }

    public String getValueExcludingTaxRounded() {
        return valueExcludingTaxRounded;
    }

    public void setValueExcludingTaxRounded(String valueExcludingTaxRounded) {
        this.valueExcludingTaxRounded = valueExcludingTaxRounded;
    }

    public String getValueIncludingTax() {
        return valueIncludingTax;
    }

    public void setValueIncludingTax(String valueIncludingTax) {
        this.valueIncludingTax = valueIncludingTax;
    }

    public String getValueIncludingTaxRounded() {
        return valueIncludingTaxRounded;
    }

    public void setValueIncludingTaxRounded(String valueIncludingTaxRounded) {
        this.valueIncludingTaxRounded = valueIncludingTaxRounded;
    }
}
