package com.hroniko.pnl.entities.tmf.agreement;

import java.util.List;

public class AgreementItem {

    /**
     * A list of agreement term or conditions.
     * Aspects of the agreement not formally specified elsewhere in the agreement
     * and that cannot be captured elsewhere in a formal notation, or automatically
     * monitored and require a more human level of management.
     */
    private List<AgreementTermOrCondition> termOrCondition;


    public List<AgreementTermOrCondition> getTermOrCondition() {
        return termOrCondition;
    }

    public void setTermOrCondition(List<AgreementTermOrCondition> termOrCondition) {
        this.termOrCondition = termOrCondition;
    }
}
