package com.hroniko.pnl.entities.tmf.oe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BPIProductRelationship {
    private ProductRelationshipType type;

    public ProductRelationshipType getType() {
        return type;
    }

    public void setType(ProductRelationshipType type) {
        this.type = type;
    }

}
