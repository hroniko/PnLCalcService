package com.hroniko.pnl.entities.tmf.oe.price;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Is an amount, usually of money, that modifies the price charged for a product.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdPriceAlteration {
    private String name;
    private String description;
    private String priceType;
    private String unitOfMeasure;
    private String recurringChargePeriod;
    private Integer applicationDuration;
    private Integer priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getRecurringChargePeriod() {
        return recurringChargePeriod;
    }

    public void setRecurringChargePeriod(String recurringChargePeriod) {
        this.recurringChargePeriod = recurringChargePeriod;
    }

    public Integer getApplicationDuration() {
        return applicationDuration;
    }

    public void setApplicationDuration(Integer applicationDuration) {
        this.applicationDuration = applicationDuration;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
