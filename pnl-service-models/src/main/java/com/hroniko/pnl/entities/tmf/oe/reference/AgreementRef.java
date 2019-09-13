package com.hroniko.pnl.entities.tmf.oe.reference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.List;
import java.util.Map;

/**
 * Agreement reference.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgreementRef {
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    private String externalId;
    @JsonProperty("@type")
    private String referredType;
    private String name;
    private String href;
    private Map<String, List<?>> extendedParameters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Map<String, List<?>> getExtendedParameters() {
        return extendedParameters;
    }

    public void setExtendedParameters(Map<String, List<?>> extendedParameters) {
        this.extendedParameters = extendedParameters;
    }
}
