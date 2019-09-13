package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hroniko.pnl.entities.tmf.oe.price.Price;
import com.hroniko.pnl.entities.tmf.oe.price.PriceAlteration;

import java.util.List;

/**
 * Description of price and discount awarded
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuotePrice {

    /**
     * Indicates the base (class) type of the quote price
     */
    @JsonProperty("@type")
    private String type;

    /**
     * link to the schema describing this REST resource
     */
    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    /**
     * Name of the quote /quote item price
     */
    private String name;

    /**
     * Description of the quote/quote item price
     */
    private String description;

    /**
     * Indicate if the price is for recurrent or no-recurrent charge
     */
    private String priceType;

    /**
     * Used for recurring charge to indicate period (month, week, etc..)
     */
    private String unitOfMeasure;

    /**
     * Used for recurring charge to indicate period (month, week, etc..)
     */
    private String recurringChargePeriod;

    /**
     * Is an amount, usually of money, that modifies the price charged for an order item
     */
    private List<PriceAlteration> priceAlteration;

    /**
     * Provides all amounts (tax included, duty free, tax rate),
     * used currency and percentage to apply for Price Alteration.
     */
    private Price price;

    private String priceValueId;

    /**
     * Id of discounted Quote Price
     */
    private String alteredPriceId;

    /**
     * Charge Type (e.g. In Advance, In Arrears)
     */
    private String chargeMethod;

    /**
     * Id of the Price Component Specification from Product Offering Catalog
     */
    private String priceComponentSpecificationRef;

    /**
     * Specification of the price type  (e.g. Activation fee, Deactivation fee
     * for non-recurrent charge, Recurrent fee for recurrent charge)
     */
    private String priceSpecificationType;

    /**
     * Charge Period (e.g. Month, Quarter, Year, Day, Week)
     */
    private String recurrentChargePeriod;

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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PriceAlteration> getPriceAlteration() {
        return priceAlteration;
    }

    public void setPriceAlteration(List<PriceAlteration> priceAlteration) {
        this.priceAlteration = priceAlteration;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getRecurringChargePeriod() {
        return recurringChargePeriod;
    }

    public void setRecurringChargePeriod(String recurringChargePeriod) {
        this.recurringChargePeriod = recurringChargePeriod;
    }

    public String getPriceValueId() {
        return priceValueId;
    }

    public void setPriceValueId(String priceValueId) {
        this.priceValueId = priceValueId;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
