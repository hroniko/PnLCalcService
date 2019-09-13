package com.hroniko.pnl.entities.tmf.oe.reference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

/**
 * ProductOffering reference.
 * A product offering represents entities that are orderable from the provider of the catalog, this resource includes pricing information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOfferingRef {
    public ProductOfferingRef(BigInteger offerId) {
        setId(offerId);
    }

    public ProductOfferingRef() {
    }

    @NotNull(message = "This is mandatory field.")
    @JsonSerialize(using = ToStringSerializer.class)
    private BigInteger id;
    private String name;
    @JsonProperty("@type")
    private String referredType;
    private String nameAdditional;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getReferredType() {
        return referredType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAdditional() {
        return nameAdditional;
    }

    public void setNameAdditional(String nameAdditional) {
        this.nameAdditional = nameAdditional;
    }

    @JsonProperty("href")
    //TODO: discuss link
    public String getLink() {
        return "/api/v1/catalogManagement/productOffering/" + getId();
    }
}
