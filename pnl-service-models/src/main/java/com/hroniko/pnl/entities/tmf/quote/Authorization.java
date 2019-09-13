package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * If special discount or special product offering price or specific
 * condition need an approval for ISP sale representative it is described here
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Authorization {
    /**
     * Nameof the required authorization
     */
    private String name;

    /**
     * State of the authorization -could be approved or declined
     */
    private String state;

    /**
     * Date when the authorization is requested for
     */
    private Date requestedDate;

    /**
     * Date when the authorization (approved or declined) has been done
     */
    private Date givenDate;

    /**
     * To describea digital or manual signature
     */
    private String signatureRepresentation;

    /**
     * Indicates the (class) type of the attachment
     */
    @JsonProperty("@type")
    private String type;

    /**
     * Link to schema describing this REST resource
     */
    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getGivenDate() {
        return givenDate;
    }

    public void setGivenDate(Date givenDate) {
        this.givenDate = givenDate;
    }

    public String getSignatureRepresentation() {
        return signatureRepresentation;
    }

    public void setSignatureRepresentation(String signatureRepresentation) {
        this.signatureRepresentation = signatureRepresentation;
    }

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
}
