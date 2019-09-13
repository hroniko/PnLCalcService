package com.hroniko.pnl.entities.tmf.agreement;

import javax.validation.constraints.NotNull;

/**
 * A party role represents the part played by a party in a given context.
 */
public class AgreementPartyRoleReference {

    /**
     * Unique identifier of the product.
     */
    @NotNull(message = "This is mandatory field.")
    private String id;

    /**
     * The identifier of the engaged party that is linked to the PartyRole object.
     */
    private String partyId;

    /**
     * Reference of the product.
     */
    private String href;

    /**
    * The name of the party role.
    */
    @NotNull(message = "This is mandatory field.")
    private String name;

    /**
     * The name of the engaged party that is linked to the PartyRole object.
     */
    private String partyName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
}