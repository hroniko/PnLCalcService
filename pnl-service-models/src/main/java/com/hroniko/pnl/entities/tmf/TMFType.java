package com.hroniko.pnl.entities.tmf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TMFType {
    private String name;
    private String partnershipId;
    private String partnershipName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartnershipId() {
        return partnershipId;
    }

    public void setPartnershipId(String partnershipId) {
        this.partnershipId = partnershipId;
    }

    public String getPartnershipName() {
        return partnershipName;
    }

    public void setPartnershipName(String getPartnershipName) {
        this.partnershipName = getPartnershipName;
    }

    @JsonProperty("partnershipHref")
    public String getLink() {
        if (partnershipId != null) {
            return "/api/v1/customerManagement/customerAccount/" + partnershipId;
        }
        return null;
    }
}