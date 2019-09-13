package com.hroniko.pnl.entities.tmf.oe;


/**
 * Linked order items to the one instantiate.
 */
public class OrderItemRelationship{
    private String id;
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
}
