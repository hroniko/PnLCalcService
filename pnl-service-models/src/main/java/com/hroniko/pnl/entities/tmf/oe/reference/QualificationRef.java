package com.hroniko.pnl.entities.tmf.oe.reference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * It could be a serviceQualification or a productOfferingQualification
 * that has been executed previously and captured in the productOrder to provide 'eligibility' information.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QualificationRef{
    private String id;
    private String name;
    private String referredType;
    private String qualificationItemId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("@referredType")
    public String getReferredType() {
        return referredType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualificationItemId() {
        return qualificationItemId;
    }

    public void setQualificationItemId(String qualificationItemId) {
        this.qualificationItemId = qualificationItemId;
    }

    @JsonProperty("href")
    public String getLink() {
        return null;
    }
}
