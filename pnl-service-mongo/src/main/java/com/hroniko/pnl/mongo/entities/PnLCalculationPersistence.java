package com.hroniko.pnl.mongo.entities;

import com.hroniko.pnl.entities.results.PnLCalculationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PnLCalculationPersistence")
public class PnLCalculationPersistence extends PnLCalculationResult {
    @Id
    private String id;

    public PnLCalculationPersistence(PnLCalculationResult result){
        this.setCustomerId(result.getCustomerId())
                .setCustomerName(result.getCustomerName())
                .setName(result.getName())
                .setNodes(result.getNodes())
                .setLocationIds(result.getLocationIds());
    }

    public String getId() {
        return id;
    }

    public PnLCalculationPersistence setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", getName())
                .append("customerId", getCustomerId())
                .append("customerName", getCustomerName())
                .append("locationIds", getLocationIds())
                .append("nodes", getNodes())
                .toString();
    }

}
