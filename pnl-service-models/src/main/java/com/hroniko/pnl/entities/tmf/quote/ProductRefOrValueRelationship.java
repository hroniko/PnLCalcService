package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a relationship between products - which potentially
 * holds an entire product object or a product reference (with partial content).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRefOrValueRelationship {

    /**
     * Type of the product relationship. It can be: - "bundled" if the product
     * is a bundle and you want to describe the "bundled" products inside this bundle - "reliesOn"
     * if the product needs another already owned product to rely on (e.g. an option on an already
     * owned mobile access product) "targets" or "isTargeted" (depending on the way of expressing the link)
     * for any other kind of links that may be useful
     */
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
