package com.hroniko.pnl.entities.tmf.quote;

public class AlertItem {

    private String id;
    private String ruleId;
    private String refType;
    private String refId;
    private String characteristicId;
    private String priceType;
    private String categoryId;

    private String alertLevel;
    private String alertType;
    private String ruleType;
    private String alertDomain;

    private String boundaryType;
    private String messageCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(String characteristicId) {
        this.characteristicId = characteristicId;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getAlertDomain() {
        return alertDomain;
    }

    public void setAlertDomain(String alertDomain) {
        this.alertDomain = alertDomain;
    }

    public String getBoundaryType() {
        return boundaryType;
    }

    public void setBoundaryType(String boundaryType) {
        this.boundaryType = boundaryType;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

}
