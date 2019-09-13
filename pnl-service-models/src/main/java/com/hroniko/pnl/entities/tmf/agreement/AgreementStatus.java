package com.hroniko.pnl.entities.tmf.agreement;

/**
 * Lifecycle status of Agreement
 */
public enum AgreementStatus{
    INITIALIZED("Initialized"),
    IN_PROCESS ("In Process"),
    PENDING_UPDATE("Pending Update"),
    VALIDATED("validated"),
    REJECTED("Rejected"),
    APPROVED("Approved");

    private final String name;
    AgreementStatus(String value) {
        name = value;
    }
    public String getTypeName(){
        return name;
    }
}