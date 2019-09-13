package com.hroniko.pnl.entities.tmf.quote;

public enum QuotePriceType {

    ONETIME("onetime"),
    RECURING ("recuring");

    private final String name;

    QuotePriceType(final String value) {
        name = value;
    }

    public String getTypeName(){
        return name;
    }
}