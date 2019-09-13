package com.hroniko.pnl.entities.tmf.oe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Product reference.
 * Configure the product relationships & characteristics
 * (only configurable characteristics and necessary only if a non default value is selected)
 * and/or identify the product that needs to be modified/deleted.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OIProduct {
    @NotNull(message = "This is mandatory field.")
    private String id;
    private String type;
    private String schemaLocation;
    private String name;
    private String description;
    private List<OIProductRelationship> productRelationship;
    private List<OIProductCharacteristic> characteristic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<OIProductRelationship> getProductRelationship() {
        return productRelationship;
    }

    public void setProductRelationship(List<OIProductRelationship> productRelationship) {
        this.productRelationship = productRelationship;
    }

    public List<OIProductCharacteristic> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(List<OIProductCharacteristic> characteristic) {
        this.characteristic = characteristic;
    }

    public String getLink() {
        return null;
    }
}
