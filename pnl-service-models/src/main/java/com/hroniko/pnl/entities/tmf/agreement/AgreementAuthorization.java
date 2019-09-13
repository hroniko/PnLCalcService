package com.hroniko.pnl.entities.tmf.agreement;

import java.util.Date;

/**
 * A business participant that is responsible for approving the agreement.
 */
public class AgreementAuthorization {

    /**
     * Authorization state.
     */
    private Date date;

    /**
     * Indication that represents whether the signature is a physical paper signature or a digital signature
     */
    private AgreementSignatureType signatureRepresentation;

    /**
     * Current status of the authorization, for example in process, approved,  rejected
     */
    private String state;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSignatureRepresentation() {
        return signatureRepresentation.getSignatureType();
    }

    public void setSignatureRepresentation(AgreementSignatureType signatureRepresentation) {
        this.signatureRepresentation = signatureRepresentation;
    }
}
