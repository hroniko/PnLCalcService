package com.hroniko.pnl.entities.tmf.agreement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * An agreement represents a contract or arrangement, either written or verbal and sometimes enforceable
 * by law, such as a service level agreement or a customer price agreement. An agreement involves a
 * number of other business entities, such as products, services, and resources and/or their specifications.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agreement {

    /**
     * The time period during which the Agreement is in effect.
     */
    private Date agreementPeriod;

    /**
     * Date at which the agreement is completed.
     */
    private Date completionDate = Date.from(Instant.now());

    /**
     * A reference number assigned to an Agreement that follows a prescribed numbering system.
     */
    private Integer documentNumber;

    /**
     * Unique url identifying the agreement as a resource.
     */
    private String href;

    /**
     * Date at which the agreement was initialized.
     */
    private Date initialDate;

    /**
     * An overview and goals of the Agreement.
     */
    private String statementOfIntent;

    /**
     * The current status of the agreement. Typical values are: in process, approved and rejected.
     */
    private AgreementStatus status;

    /**
     * The type of the agreement. For example "commercial".
     */
    @NotNull(message = "This is mandatory field.")
    private String type;

    /**
     * A string identifying the version of the agreement.
     */
    private String version = "0";

    /**
     * Reference to an AgreementSpecification which represents a template of an agreement that can be
     * used when establishing partnerships.
     */
    private AgreementSpecificationReference agreementSpecification;

    /**
     * A list of agreement items.
     * A part of the agreement expressed in terms of a product offering and possibly including specific terms and conditions.
     */
    @NotNull(message = "This is mandatory field.")
    @JsonProperty("agreementItem")
    private List<AgreementItem> agreementItems;

    /**
     * A list of party role references.
     * A party role represents the part played by a party in a given context.
     */
    @NotNull(message = "This is mandatory field.")
    @JsonProperty("engagedPartyRole")
    private List<AgreementPartyRoleReference> engagedPartyRoles;

    /**
     * A list of agreement authorizations.
     * A business participant that is responsible for approving the agreement.
     */
    @JsonProperty("agreementAuthorization")
    private List<AgreementAuthorization> agreementAuthorizations;

    /**
     * A list of characteristics.
     * Describes a given characteristic of an object or entity through a name/value pair.
     */
    @JsonProperty("characteristic")
    private List<AgreementCharacteristic> characteristics;

    /**
     *Identifier of the agreement
     */
    private String id;

    /**
     *Name of the agreement
     */
    private String name;

    // region Gets & Sets

    public Date getAgreementPeriod() {
        return agreementPeriod;
    }

    public void setAgreementPeriod(Date agreementPeriod) {
        this.agreementPeriod = agreementPeriod;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }


    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public String getStatementOfIntent() {
        return statementOfIntent;
    }

    public void setStatementOfIntent(String statementOfIntent) {
        this.statementOfIntent = statementOfIntent;
    }

    public String getStatus() {
        return this.status != null ? this.status.getTypeName() : null;
    }

    public void setStatus(AgreementStatus status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public AgreementSpecificationReference getAgreementSpecification() {
        return agreementSpecification;
    }

    public void setAgreementSpecification(AgreementSpecificationReference agreementSpecification) {
        this.agreementSpecification = agreementSpecification;
    }

    public List<AgreementItem> getAgreementItems() {
        return agreementItems;
    }

    public void setAgreementItems(List<AgreementItem> agreementItems) {
        this.agreementItems = agreementItems;
    }

    public List<AgreementPartyRoleReference> getEngagedPartyRoles() {
        return engagedPartyRoles;
    }

    public void setEngagedPartyRoles(List<AgreementPartyRoleReference> engagedPartyRoles) {
        this.engagedPartyRoles = engagedPartyRoles;
    }

    public List<AgreementAuthorization> getAgreementAuthorizations() {
        return agreementAuthorizations;
    }

    public void setAgreementAuthorizations(List<AgreementAuthorization> agreementAuthorizations) {
        this.agreementAuthorizations = agreementAuthorizations;
    }

    public List<AgreementCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<AgreementCharacteristic> characteristics) {
        this.characteristics = characteristics;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    // endregion
}