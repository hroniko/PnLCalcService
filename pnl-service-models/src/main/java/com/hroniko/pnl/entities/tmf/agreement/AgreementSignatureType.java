package com.hroniko.pnl.entities.tmf.agreement;

/**
 * Represents Agreement signature type.
 */
public enum  AgreementSignatureType {
    PHYSICAL_PAPER("Physical Paper"),
    DIGITAL("Digital");

    private final String type;

    AgreementSignatureType(String type) {
        this.type = type;
    }

    public String getSignatureType(){
        return type;
    }
}
