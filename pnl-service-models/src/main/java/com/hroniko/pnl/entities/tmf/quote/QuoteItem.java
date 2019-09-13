package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hroniko.pnl.entities.tmf.Note;
import com.hroniko.pnl.entities.tmf.oe.reference.AppointmentRef;
import com.hroniko.pnl.entities.tmf.oe.reference.BillingAccountRef;
import com.hroniko.pnl.entities.tmf.oe.reference.ProductOfferingRef;
import com.hroniko.pnl.entities.tmf.oe.reference.RelatedPartyRef;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * A quote items describe an action to be performed on a productOffering
 * or a product in order to get pricing elements and condition.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteItem {
    /**
     * Identifier of the quote item (generally it is a sequence number 01, 02, 03, ...)
     */
    @NotNull
    private String id;

    /**
     * State of the quote item
     */
    private String state;

    /**
     * Action to be performed on this quote item (add, modify, remove, etc.).
     */
    @NotNull(message = "This is mandatory field.")
    private String action;

    /**
     * Indicates the quantity to be quoted
     */
    private Integer quantity;

    /**
     * Link to the schema describing this REST resource
     */
    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    /**
     * Indicates the base (class) type of the quote Item.
     */
    @JsonProperty("@type")
    private String type;

    /**
     * Used to describe relationship between quote item.
     * These relationships could have an impact on pricing and conditions
     */
    @Valid
    private List<QuoteItemRelationship> quoteItemRelationship;

    /**
     * Extra information about a given entity
     */
    private List<Note> note;

    /**
     * A related party defines party or party role linked to a specific entity.
     */
    private List<RelatedPartyRef> relatedParty;

    /**
     * A list of appointment references
     */
    @Valid
    private List<AppointmentRef> appointment;

    /**
     * A product offering represents entities that are
     * orderable from the provider of the catalog, this resource includes pricing information.
     */
    @Valid
    private ProductOfferingRef productOffering;

    /**
     * Description of price and discount awarded
     */
    private List<QuotePrice> quoteItemPrice;

    /**
     * Product reference. Configure the product characteristics
     * (only configurable characteristics and necessary only if a non default
     * value is selected) and/or identify the product that needs to be modified/deleted
     */
    @Valid
    private ProductRefOrValue product;

    /**
     * Billing account reference
     */
    private List<BillingAccountRef> billingAccount;

    /**
     * An agreement represents a contract or arrangement, either written or verbal and sometimes
     * enforceable by law, such as a service level agreement or a customer price agreement.
     * An agreement involves a number of other business entities, such as products, services,
     * and resources and/or their specifications.
     */
    private String agreementId;

    /**
     * Period in which an applied Discount or Product is valid
     */
    private String applicationDuration;

    /**
     * Id of the Billing Account to which the Quote Item is assigned
     */
    private String billingAccountId;

    /**
     * Extension point for project parameters
     */
    private Map extendedParameters;

    /**
     * Unique identifier of the group (e.g. manual group of Quote Items on CPQ UI)
     */
    private String groupId;

    /**
     * Id of Product Offering Category via which this Quote Item is involved in the Quote
     */
    private String involvedViaCategory;

    /**
     * Id of the parent Quote Item
     */
    private String parentQuoteItemId;

    /**
     * Quote Item Type (e.g. Product, Discount and so on)
     */
    private String quoteItemType;

    /**
     * Id of the root (top) Quote Item
     */
    private String rootQuoteItemId;

    /**
     * Date until which the Quote Item is active (valid From + application Duration)
     */
    private Date validFor;

    /**
     * Date when the Quote Item was activated
     */
    private Date validFrom;

    /**
     * Reference (id) from Discount Quote Item to Product Quote ITem
     */
    private String discountedQuoteItem;

    /**
     * Reference to MSA Agreement
     */
    private String msaAgreementRef;

    public String getMsaAgreementRef() {
        return msaAgreementRef;
    }

    public void setMsaAgreementRef(String msaAgreementRef) {
        this.msaAgreementRef = msaAgreementRef;
    }

    public String getDiscountedQuoteItem() {
        return discountedQuoteItem;
    }

    public void setDiscountedQuoteItem(String discountedQuoteItem) {
        this.discountedQuoteItem = discountedQuoteItem;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<QuoteItemRelationship> getQuoteItemRelationship() {
        return quoteItemRelationship;
    }

    public void setQuoteItemRelationship(List<QuoteItemRelationship> quoteItemRelationship) {
        this.quoteItemRelationship = quoteItemRelationship;
    }

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }

    public List<RelatedPartyRef> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(List<RelatedPartyRef> relatedParty) {
        this.relatedParty = relatedParty;
    }

    public List<AppointmentRef> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<AppointmentRef> appointment) {
        this.appointment = appointment;
    }

    public ProductOfferingRef getProductOffering() {
        return productOffering;
    }

    public void setProductOffering(ProductOfferingRef productOffering) {
        this.productOffering = productOffering;
    }

    public List<QuotePrice> getQuoteItemPrice() {
        return quoteItemPrice;
    }

    public void setQuoteItemPrice(List<QuotePrice> quoteItemPrice) {
        this.quoteItemPrice = quoteItemPrice;
    }

    public ProductRefOrValue getProduct() {
        return product;
    }

    public void setProduct(ProductRefOrValue product) {
        this.product = product;
    }

    public List<BillingAccountRef> getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(List<BillingAccountRef> billingAccount) {
        this.billingAccount = billingAccount;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getApplicationDuration() {
        return applicationDuration;
    }

    public void setApplicationDuration(String applicationDuration) {
        this.applicationDuration = applicationDuration;
    }

    public String getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(String billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    public Map getExtendedParameters() {
        return extendedParameters;
    }

    public void setExtendedParameters(Map extendedParameters) {
        this.extendedParameters = extendedParameters;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getInvolvedViaCategory() {
        return involvedViaCategory;
    }

    public void setInvolvedViaCategory(String involvedViaCategory) {
        this.involvedViaCategory = involvedViaCategory;
    }

    public String getParentQuoteItemId() {
        return parentQuoteItemId;
    }

    public void setParentQuoteItemId(String parentQuoteItemId) {
        this.parentQuoteItemId = parentQuoteItemId;
    }

    public String getQuoteItemType() {
        return quoteItemType;
    }

    public void setQuoteItemType(String quoteItemType) {
        this.quoteItemType = quoteItemType;
    }

    public String getRootQuoteItemId() {
        return rootQuoteItemId;
    }

    public void setRootQuoteItemId(String rootQuoteItemId) {
        this.rootQuoteItemId = rootQuoteItemId;
    }

    public Date getValidFor() {
        return validFor;
    }

    public void setValidFor(Date validFor) {
        this.validFor = validFor;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }
}
