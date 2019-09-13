package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.List;

/**
 * Product reference.
 * Configure the product characteristics (only configurable characteristics and necessary only if
 * a non default value is selected) and/or identify the product that needs to be modified/deleted.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRefOrValue {
    /**
     * Unique identifier of the product
     */
//    @NotNull(message = "This is mandatory field.")
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    /**
     * Name of the product
     */
    private String name;


    /**
     * Represents a relationship between products - which potentially
     * holds an entire product object or a product reference (with partial content)
     */
    private List<ProductRefOrValueRelationship> productRelationship;

    /**
     * Reference of the product
     */
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

    public List<ProductRefOrValueRelationship> getProductRelationship() {
        return productRelationship;
    }

    public void setProductRelationship(List<ProductRefOrValueRelationship> productRelationship) {
        this.productRelationship = productRelationship;
    }
}
