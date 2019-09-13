package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Quote can be used to negotiate service and product acquisition
 * or modification between a customer and a service provider.
 * Quote contain list of quote items, a reference to customer (partyRole),
 * a list of productOffering and attached prices and conditions
 * Model: https://bass.netcracker.com/pages/viewpage.action?pageId=513793351
 * Version: v.10 (Jun 19, 2018 03:34)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote{
    /**
     * Unique identifier -attributed by quoting system
     */
    private String id;

    /**
     * ID given by the consumer and only understandable
     * by him (to facilitate his searches afterwards)
     */
    private String externalId;

    private Date expirationDate;

    /**
     * Quote version -if the customer rejected the quote but
     * negotiations still open a new version of the quote is managed
     */

    private String version = "1";

    /**
     * Description of the quote
     */
    private String description;

    /**
     * Used to categorize the quote from a business perspective
     * that can be useful for the CRM system (e.g. "enterprise", "residential", ...)
     */
    private String category = "uncategorized";

    /**
     * State of the quote:described in the state-machine diagram above
     */
    private String state;

    /**
     * Date and time when the quote was created
     */
    private Date quoteDate;

    /**
     * This is expected date -from quote requester -to have a response for this quote
     */
    private Date expectedQuoteCompletionDate;

    /**
     * This is the date wished by the requester to have the requested quote item delivered
     */
    private Date expectedFulfillmentStartDate;

    /**
     * Date when the quote has been completed
     */
    private Date effectiveQuoteCompletionDate;

    /**
     * Link to the schema describing the REST resource
     */
    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    /**
     * Indicates the (class) type of the quote
     */
    @JsonProperty("@base")
    private String base;

    /**
     * Indicates the base (class) type of the quote
     */
    @JsonProperty("@baseType")
    private String baseType;

    /**
     * If special discount or special product offering price or specific
     * condition need an approval for ISP sale representative it is described here
     */
    private List<Authorization> quoteAuthorization;


    /**
     * Indicates the contact medium that could be used to contact the party
     */
    private List<ContactMedium> contactMedium;

    /**
     * A quote items describe an action to be performed on a productOffering
     * or a product in order to get pricing elements and condition
     */
    @NotNull(message = "This is mandatory field.")
    @Valid
    private List<QuoteItem> quoteItem;

    /**
     * Description of price and discount awarded
     */
    private List<QuotePrice> quoteTotalPrice;

    /**
     * Type of signature for quote acceptance
     */
    private String acceptanceSignatureType;

    /**
     * The name of the user/team to whom this Quote is assigned
     */
    private String assignTo;

    /**
     * The reason (from a list of Cancellation Reasons) why the Quote has been cancelled
     */
    private String cancellationReason;

    /**
     * The reason (from the free text field) why the Quote has been cancelled
     */
    private String cancellationReasonDescription;

    /**
     * Category of the customer account
     */
    private String customerCategory;

    /**
     * The date provided by the service provider when the Quote will be fulfilled
     */
    private Date customerCommittedDate;

    /**
     * Id of the customer account
     */
    private String customerId;

    /**
     * The date when the customer requests the Quote to be fulfilled
     */
    private Date customerRequestedDate;

    /**
     * Distribution Channel id through which the Quote has been created
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private BigInteger distributionChannelId;

    /**
     * Distribution Channel name through which the Quote has been created
     */
    private String distributionChannelName;

    /**
     *Name of the Quote
     */
    private String name;

    /**
     * Id of the Opportunity
     */
    private String opportunityId;

    /**
     *Sales person that owns the Quote and intends to receive incentives
     */
    private String owner;

    /**
     *Attribute is used to mark in-flight Quote. Increased in case changes are done to the Quote after submission
     */
    private Integer revision;

    /**
     *Date when the snapshot was done
     */
    private Date snapshotDate;

    /**
     *Version of the snapshot. Increased in case a new snapshot of the Quote is done
     */
    private Integer snapshotVersion;

    /**
     * The reason (from a list of State Change Reasons) why the Quote state has been changed.
     */
    private String stateChangeReason;

    /**
     *Status of the Quote
     */
    private String status;

    /**
     *Description of the Quote status
     */
    private String statusDescription;

    /**
     *Date and time when the Quote was updated
     */
    private Date updatedWhen;

    private String salesUser;
    private String salesUserId;
    private String salesUserId2;
    private String salesUserId3;
    private String salesUsersEmail;
    private String salesUsersLandline;
    private String salesUsersMobile;

    private List<GroupItem> groupItems;

    private List<AlertItem> alertItems;

    /**
     * Extension point for project parameters
     */
    private Map<String, List<?>> extendedParameters;

    /**
     * Hyperlink to access the quote
     */

    @JsonProperty("href")
    public String getLink() {
        return null;
    }

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) {
        this.quoteDate = quoteDate;
    }

    public Date getExpectedQuoteCompletionDate() {
        return expectedQuoteCompletionDate;
    }

    public void setExpectedQuoteCompletionDate(Date expectedQuoteCompletionDate) {
        this.expectedQuoteCompletionDate = expectedQuoteCompletionDate;
    }

    public Date getExpectedFulfillmentStartDate() {
        return expectedFulfillmentStartDate;
    }

    public void setExpectedFulfillmentStartDate(Date expectedFulfillmentStartDate) {
        this.expectedFulfillmentStartDate = expectedFulfillmentStartDate;
    }

    public Date getEffectiveQuoteCompletionDate() {
        return effectiveQuoteCompletionDate;
    }

    public void setEffectiveQuoteCompletionDate(Date effectiveQuoteCompletionDate) {
        this.effectiveQuoteCompletionDate = effectiveQuoteCompletionDate;
    }


    public List<Authorization> getQuoteAuthorization() {
        return quoteAuthorization;
    }

    public void setQuoteAuthorization(List<Authorization> quoteAuthorization) {
        this.quoteAuthorization = quoteAuthorization;
    }

    public List<ContactMedium> getContactMedium() {
        return contactMedium;
    }

    public void setContactMedium(List<ContactMedium> contactMedium) {
        this.contactMedium = contactMedium;
    }

    public List<QuoteItem> getQuoteItem() {
        return quoteItem;
    }

    public void setQuoteItem(List<QuoteItem> quoteItem) {
        this.quoteItem = quoteItem;
    }

    public List<QuotePrice> getQuoteTotalPrice() {
        return quoteTotalPrice;
    }

    public void setQuoteTotalPrice(List<QuotePrice> quoteTotalPrice) {
        this.quoteTotalPrice = quoteTotalPrice;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public String getAcceptanceSignatureType() {
        return acceptanceSignatureType;
    }

    public void setAcceptanceSignatureType(String acceptanceSignatureType) {
        this.acceptanceSignatureType = acceptanceSignatureType;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getCancellationReasonDescription() {
        return cancellationReasonDescription;
    }

    public void setCancellationReasonDescription(String cancellationReasonDescription) {
        this.cancellationReasonDescription = cancellationReasonDescription;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public Date getCustomerCommittedDate() {
        return customerCommittedDate;
    }

    public void setCustomerCommittedDate(Date customerCommittedDate) {
        this.customerCommittedDate = customerCommittedDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getCustomerRequestedDate() {
        return customerRequestedDate;
    }

    public void setCustomerRequestedDate(Date customerRequestedDate) {
        this.customerRequestedDate = customerRequestedDate;
    }

    public BigInteger getDistributionChannelId() {
        return distributionChannelId;
    }

    public void setDistributionChannelId(BigInteger distributionChannelId) {
        this.distributionChannelId = distributionChannelId;
    }

    public String getDistributionChannelName() {
        return distributionChannelName;
    }

    public void setDistributionChannelName(String distributionChannelName) {
        this.distributionChannelName = distributionChannelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(String opportunityId) {
        this.opportunityId = opportunityId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public Integer getSnapshotVersion() {
        return snapshotVersion;
    }

    public void setSnapshotVersion(Integer snapshotVersion) {
        this.snapshotVersion = snapshotVersion;
    }

    public String getStateChangeReason() {
        return stateChangeReason;
    }

    public void setStateChangeReason(String stateChangeReason) {
        this.stateChangeReason = stateChangeReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public Date getUpdatedWhen() {
        return updatedWhen;
    }

    public void setUpdatedWhen(Date updatedWhen) {
        this.updatedWhen = updatedWhen;
    }

    public List<GroupItem> getGroupItems() {
        return groupItems;
    }

    public void setGroupItems(List<GroupItem> groupItems) {
        this.groupItems = groupItems;
    }

    public List<AlertItem> getAlertItems() {
        return alertItems;
    }

    public void setAlertItems(List<AlertItem> alertItems) {
        this.alertItems = alertItems;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSalesUser() {
        return salesUser;
    }

    public void setSalesUser(String salesUser) {
        this.salesUser = salesUser;
    }

    public String getSalesUserId() {
        return salesUserId;
    }

    public void setSalesUserId(String salesUserId) {
        this.salesUserId = salesUserId;
    }

    public String getSalesUserId2() {
        return salesUserId2;
    }

    public void setSalesUserId2(String salesUserId2) {
        this.salesUserId2 = salesUserId2;
    }

    public String getSalesUserId3() {
        return salesUserId3;
    }

    public void setSalesUserId3(String salesUserId3) {
        this.salesUserId3 = salesUserId3;
    }

    public String getSalesUsersEmail() {
        return salesUsersEmail;
    }

    public void setSalesUsersEmail(String salesUsersEmail) {
        this.salesUsersEmail = salesUsersEmail;
    }

    public String getSalesUsersLandline() {
        return salesUsersLandline;
    }

    public void setSalesUsersLandline(String salesUsersLandline) {
        this.salesUsersLandline = salesUsersLandline;
    }

    public String getSalesUsersMobile() {
        return salesUsersMobile;
    }

    public void setSalesUsersMobile(String salesUsersMobile) {
        this.salesUsersMobile = salesUsersMobile;
    }


    public Map<String, List<?>> getExtendedParameters() {
        return extendedParameters;
    }

    public void setExtendedParameters(Map<String, List<?>> extendedParameters) {
        this.extendedParameters = extendedParameters;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("externalId", externalId)
                .append("expirationDate", expirationDate)
                .append("version", version)
                .append("description", description)
                .append("category", category)
                .append("state", state)
                .append("quoteDate", quoteDate)
                .append("expectedQuoteCompletionDate", expectedQuoteCompletionDate)
                .append("expectedFulfillmentStartDate", expectedFulfillmentStartDate)
                .append("effectiveQuoteCompletionDate", effectiveQuoteCompletionDate)
                .append("quoteAuthorization", quoteAuthorization)
                .append("contactMedium", contactMedium)
                .append("quoteItem", quoteItem)
                .append("quoteTotalPrice", quoteTotalPrice)
                .append("baseType", baseType)
                .append("base", base)
                .append("schemaLocation", schemaLocation)
                .append("acceptanceSignatureType", acceptanceSignatureType)
                .append("assignTo", assignTo)
                .append("cancellationReason", cancellationReason)
                .append("cancellationReasonDescription", cancellationReasonDescription)
                .append("customerCategory", customerCategory)
                .append("customerCommittedDate", customerCommittedDate)
                .append("customerId", customerId)
                .append("customerRequestedDate", customerRequestedDate)
                .append("distributionChannelId", distributionChannelId)
                .append("distributionChannelName", distributionChannelName)
                .append("name", name)
                .append("opportunityId", opportunityId)
                .append("owner", owner)
                .append("revision", revision)
                .append("snapshotDate", snapshotDate)
                .append("snapshotVersion", snapshotVersion)
                .append("stateChangeReason", stateChangeReason)
                .append("status", status)
                .append("statusDescription", statusDescription)
                .append("updatedWhen", updatedWhen)
                .append("salesUser", salesUser)
                .append("salesUserId", salesUserId)
                .append("salesUserId2", salesUserId2)
                .append("salesUserId3", salesUserId3)
                .append("salesUsersEmail", salesUsersEmail)
                .append("salesUsersLandline", salesUsersLandline)
                .append("salesUsersMobile", salesUsersMobile)
                .append("groupItems", groupItems)
                .append("alertItems", alertItems)
                .append("extendedParameters", extendedParameters)
                .toString();
    }
}
