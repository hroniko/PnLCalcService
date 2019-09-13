package com.hroniko.pnl.entities.tmf.oe.price;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;

/**
 * An amount, usually of money, that represents the actual price paid by the Customer for this item or this order.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPrice {
    @JsonIgnore
    private BigInteger tomsId;
    @JsonIgnore
    private BigInteger tomsParentId;
    private String type;
    private String schemaLocation;
    private String name;
    private String description;
    private String priceType;
    private String unitOfMeasure;
    private String recurringChargePeriod;
    private List<PriceAlteration> priceAlteration;

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("@schemaLocation")
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


    public List<PriceAlteration> getPriceAlteration() {
        return priceAlteration;
    }

    public void setPriceAlteration(List<PriceAlteration> priceAlteration) {
        this.priceAlteration = priceAlteration;
    }

    public BigInteger getTomsId() {
        return tomsId;
    }

    public void setTomsId(BigInteger tomsId) {
        this.tomsId = tomsId;
    }

    public BigInteger getTomsParentId() {
        return tomsParentId;
    }

    public void setTomsParentId(BigInteger tomsParentId) {
        this.tomsParentId = tomsParentId;
    }
}
