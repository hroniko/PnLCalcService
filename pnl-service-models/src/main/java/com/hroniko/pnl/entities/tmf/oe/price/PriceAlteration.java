package com.hroniko.pnl.entities.tmf.oe.price;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.math.BigInteger;
import java.util.Date;

/**
 * Is an amount, usually of money, that modifies the price charged for an order item.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceAlteration {
    @JsonIgnore
    private BigInteger tomsId;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String name;
    private String description;
    private String priceType;
    private String unitOfMeasure;
    private String recurringChargePeriod;
    private Integer applicationDuration;
    private Integer priority;
    private String priceCondition;
    @JsonSerialize(using = DateSerializer.class)
    private Date validFor;

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


    public BigInteger getTomsId() {
        return tomsId;
    }

    public void setTomsId(BigInteger tomsId) {
        this.tomsId = tomsId;
    }

    public String getPriceCondition() {
        return priceCondition;
    }

    public void setPriceCondition(String priceCondition) {
        this.priceCondition = priceCondition;
    }

    public Date getValidFor() {
        return validFor;
    }

    public void setValidFor(Date validFor) {
        this.validFor = validFor;
    }
}
