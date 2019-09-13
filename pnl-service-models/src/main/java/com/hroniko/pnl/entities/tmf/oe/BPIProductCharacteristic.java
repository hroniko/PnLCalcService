package com.hroniko.pnl.entities.tmf.oe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Characteristics of the {@link BPIProduct } to instantiate or to modify.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BPIProductCharacteristic {
    private String name;
    private String value;

    public BPIProductCharacteristic(String name, Object value) {
        this.name = name;
        this.value = value.toString();
    }

    public BPIProductCharacteristic() {
    }

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
