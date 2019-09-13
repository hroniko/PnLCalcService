package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Used to describe relationship between quote item.
 * These relationships could have an impact on pricing and conditions
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteItemRelationship {
    /**
     * ID of the related order item (must be in the same quote)
     */
    private String id;
    /**
     * Relationship type as relies on, bundles, etc...
     */
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Types{
        private Types(){}
        public final static String CHILD = "isChild";
        public final static String PARENT = "isParent";

    }
}
