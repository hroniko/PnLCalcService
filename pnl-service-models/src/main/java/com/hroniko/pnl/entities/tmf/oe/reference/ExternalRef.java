package com.hroniko.pnl.entities.tmf.oe.reference;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ExternalRef {

    private String name;
    private String refId;
    private String refType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("refId", refId)
                .append("refType", refType)
                .toString();
    }
}
