package com.hroniko.pnl.entities.tmf.oe.price;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * An amount, usually of money, that represents the actual price paid by the Customer for a purchase, a rent or a lease of a Product.
 * The price is valid for defined period of time
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPrice {
    private String name;
    private String description;
    private String priceType;
    private String recurringChargePeriod;
    private String unitOfMeasure;
    private List<ProdPriceAlteration> prodPriceAlteration;

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


    public List<ProdPriceAlteration> getProdPriceAlteration() {
        return prodPriceAlteration;
    }

    public void setProdPriceAlteration(List<ProdPriceAlteration> prodPriceAlteration) {
        this.prodPriceAlteration = prodPriceAlteration;
    }
}
