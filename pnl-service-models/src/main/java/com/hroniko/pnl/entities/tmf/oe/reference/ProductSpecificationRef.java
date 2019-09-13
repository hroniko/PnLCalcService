package com.hroniko.pnl.entities.tmf.oe.reference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.NotNull;

/**
 * Product specification reference:
 * A ProductSpecification is a detailed description of a tangible
 * or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductSpecificationRef {
    @NotNull(message = "This is mandatory field.")
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String version;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
