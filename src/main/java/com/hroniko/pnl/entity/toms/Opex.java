package com.hroniko.pnl.entity.toms;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigInteger;

public class Opex {
    private String name;
    private String description;
    private BigInteger offeringId;
    private String offeringName;
    private Double value;

    public String getName() {
        return name;
    }

    public Opex setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Opex setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigInteger getOfferingId() {
        return offeringId;
    }

    public Opex setOfferingId(BigInteger offeringId) {
        this.offeringId = offeringId;
        return this;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public Opex setOfferingName(String offeringName) {
        this.offeringName = offeringName;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Opex setValue(Double value) {
        this.value = value;
        return this;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("name", name)
                .append("description", description)
                .append("offeringId", offeringId)
                .append("offeringName", offeringName)
                .append("value", value)
                .toString();
    }
}
