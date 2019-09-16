package com.hroniko.pnl.entities.catalog;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.Id;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Capex {

    @Id
    private Long id;

    private String name;
    private String description;
    private BigInteger offeringId;
    private String offeringName;
    private Double value;

    private List<Capex> capexList;

    public Capex() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public Long getId() {
        return id;
    }

    public Capex setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Capex setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public Capex setName(String name) {
        this.name = name;
        return this;
    }

    public BigInteger getOfferingId() {
        return offeringId;
    }

    public Capex setOfferingId(BigInteger offeringId) {
        this.offeringId = offeringId;
        return this;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public Capex setOfferingName(String offeringName) {
        this.offeringName = offeringName;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Capex setValue(Double value) {
        this.value = value;
        return this;
    }

    public List<Capex> getCapexList() {
        return capexList;
    }

    public Capex setCapexList(List<Capex> capexList) {
        this.capexList = capexList;
        return this;
    }

    public Capex addCapex(Capex capex){
        if (capexList == null) {
            capexList = new ArrayList<>();
        }
        if (!capexList.contains(capex))
            capexList.add(capex);
        return this;
    }

    public Capex addCapexs(Capex ... capexs){
        for (Capex capex : capexs){
            addCapex(capex);
        }
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("offeringId", offeringId)
                .append("offeringName", offeringName)
                .append("value", value)
                .append("capexList", capexList)
                .toString();
    }
}
