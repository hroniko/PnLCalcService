package com.hroniko.pnl.entities.tmf.oe.reference;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Used to defined a place useful for the product.
 */
public class BPIPlace {
    private String role;
    @JsonIgnore
    private String locationId;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLink() {
        return "" + locationId;
    }
}
