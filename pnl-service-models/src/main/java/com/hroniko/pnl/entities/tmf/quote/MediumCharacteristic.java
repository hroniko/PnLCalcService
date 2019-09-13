package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes the contact medium characteristics that could
 * be used to contact a party (an individual or an organization)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediumCharacteristic {
    /**
     * The city
     */
    private String city;
    /**
     * The country
     */
    private String country;

    /**
     * Full email address in standard format
     */
    private String emailAddress;

    /**
     * Type of medium (fax, mobile phone...)
     */
    @JsonProperty("type")
    private String typeOfMedium;

    /**
     * Postcode
     */
    private String postCode;

    /**
     * State or province
     */
    private String stateOrProvince;

    /**
     * Describes the street
     */
    private String street1;

    /**
     * Complementary street description
     */
    private String street2;

    /**
     * The fax number of the contact
     */
    private String faxNumber;

    /**
     * The primary phone number of the contact
     */
    private String phoneNumber;

    /**
     * Indicates the (class) type of the medium characteristic
     */
    @JsonProperty("@type")
    private String type;

    /**
     * Link to the schema describing this REST resource
     */
    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTypeOfMedium() {
        return typeOfMedium;
    }

    public void setTypeOfMedium(String typeOfMedium) {
        this.typeOfMedium = typeOfMedium;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
