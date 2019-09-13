package com.hroniko.pnl.entities.tmf.agreement;

/**
 * Characteristic of an Agreement object or entity through a name/value pair
 */
public class AgreementCharacteristic {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
