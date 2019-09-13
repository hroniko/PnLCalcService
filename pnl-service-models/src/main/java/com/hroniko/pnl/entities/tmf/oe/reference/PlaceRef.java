package com.hroniko.pnl.entities.tmf.oe.reference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Place reference.
 * Place defines the places where the products are sold or delivered.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceRef {
    private String schemaLocation;
    private String referredType;
    @NotNull(message = "This is mandatory field.")
    private String role;
    @NotNull(message = "This is mandatory field.")
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    private String name;
    private BigInteger externalId;
    /**
     * Address of the Place
     */
    private String address;
    /**
     * Id of the geographical area to which this Place belongs
     */
    private String marketId;
    /**
     * Name of the geographical area to which this Place belongs
     */
    private String marketName;
    /**
     * This Location is added to the Quote or isn't
     */
    private boolean addedToTheQuote;
    /**
     * Extension point for project parameters
     */
    private Map<String, List<?>> extendedParameters;

    @JsonProperty("@schemaLocation")
    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    @JsonProperty("@referredType")
    public String getReferredType() {
        return referredType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("href")
    public String getLink() {
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getExternalId() {
        return externalId;
    }

    public void setExternalId(BigInteger externalId) {
        this.externalId = externalId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public boolean isAddedToTheQuote() {
        return addedToTheQuote;
    }

    public void setAddedToTheQuote(boolean addedToTheQuote) {
        this.addedToTheQuote = addedToTheQuote;
    }

    public Map<String, List<?>> getExtendedParameters() {
        return extendedParameters;
    }

    public void setExtendedParameters(Map<String, List<?>> extendedParameters) {
        this.extendedParameters = extendedParameters;
    }

    public static final class Type {
        private Type() {
        }

        public static final String SERVICE_LOCATION = "serviceLocation";
        public static final String CUSTOMER_LOCATION = "customerLocation";
    }
}
