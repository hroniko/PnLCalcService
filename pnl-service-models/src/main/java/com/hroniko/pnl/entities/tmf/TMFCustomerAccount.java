package com.hroniko.pnl.entities.tmf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TMFCustomerAccount extends TMFBase {
    private String status;
    private String statusReason;
    private List<TMFAccount> account;
    private List<TMFPaymentMethod> paymentMethod;
    private List<TMFContactMedium> contactMedium;
    private List<TMFRelatedParty> relatedParty;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public List<TMFAccount> getAccount() {
        return account;
    }

    public void setAccount(List<TMFAccount> account) {
        this.account = account;
    }

    public List<TMFPaymentMethod> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<TMFPaymentMethod> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<TMFContactMedium> getContactMedium() {
        return contactMedium;
    }

    public void setContactMedium(List<TMFContactMedium> contactMedium) {
        this.contactMedium = contactMedium;
    }

    public List<TMFRelatedParty> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(List<TMFRelatedParty> relatedParty) {
        this.relatedParty = relatedParty;
    }

    @JsonProperty("href")
    public String getLink() {
        return "/api/v1/customerManagement/customerAccount/" + getId();
    }
}
