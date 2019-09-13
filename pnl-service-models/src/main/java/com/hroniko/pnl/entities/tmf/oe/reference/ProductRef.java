package com.hroniko.pnl.entities.tmf.oe.reference;

import java.math.BigInteger;

/**
 * Product reference.
 * Configure the product characteristics (only configurable characteristics and necessary
 * only if a non default value is selected) and/or identify the product that needs to be modified/deleted
 * May be a bundle product instantiation, in the case, it will contain the list of bundled product to instantiate
 * Note: Each product to instantiate corresponds to a purchased productOffering. In case of bundles, the
 * order of the list in the productOffering bundle must match the order of the list of the product instance
 * bundle to deliver.
 */
public class ProductRef{
    private String id;

    public ProductRef() {
    }

    public ProductRef(BigInteger oiId) {
        this.id = oiId.toString();
    }

    public String getLink() {
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
