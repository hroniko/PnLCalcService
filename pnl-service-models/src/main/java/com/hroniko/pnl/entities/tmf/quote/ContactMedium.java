package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.util.Date;

/**
 * Indicates the contact medium that could be used to contact the party
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactMedium {
    /**
     * If true, indicates that is the preferred contact medium
     */
    private Boolean preferred;

    /**
     * Type of the contact medium, such as: email address,
     * telephone number, postal address
     */
    private String type;

    /**
     * The time period that the contact medium is valid for
     */
    @JsonSerialize(using = DateSerializer.class)
    private Date validFor;

    /**
     * Describes the contact medium characteristics that could be
     * used to contact a party (an individual or an organization)
     */
    private String characteristic;

    public Boolean getPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getValidFor() {
        return validFor;
    }

    public void setValidFor(Date validFor) {
        this.validFor = validFor;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
}
