package com.hroniko.pnl.entities.price;

import com.hroniko.pnl.entities.tmf.oe.price.Price;
import com.hroniko.pnl.entities.tmf.quote.QuoteItem;
import com.hroniko.pnl.entities.tmf.quote.QuotePrice;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigInteger;
import java.util.Objects;

import static com.hroniko.pnl.entities.constants.PriceType.*;

public class PriceItem {
    private BigInteger offeringId;
    private String offeringName;
    private Double totalMRC;
    private Double totalNRC;
    private Integer quantity;

    public PriceItem(QuoteItem quoteItem) {

        this.totalNRC = quoteItem.getQuoteItemPrice().stream()
                .filter(quotePrice -> NRC.equals(quotePrice.getPriceType()))
                .map(QuotePrice::getPrice)
                .filter(Objects::nonNull)
                .map(Price::getValueExcludingTax)
                .filter(Objects::nonNull)
                .map(this::toDoubleValue)
                .reduce(0.0, Double::sum);

        this.totalMRC = quoteItem.getQuoteItemPrice().stream()
                .filter(quotePrice -> MRC.equals(quotePrice.getPriceType()))
                .map(QuotePrice::getPrice)
                .filter(Objects::nonNull)
                .map(Price::getValueExcludingTax)
                .filter(Objects::nonNull)
                .map(this::toDoubleValue)
                .reduce(0.0, Double::sum);
        this.quantity = quoteItem.getQuantity() == null ? 0 : quoteItem.getQuantity();
        this.offeringId = quoteItem.getProductOffering().getId();
        this.offeringName = quoteItem.getProductOffering().getName();

    }

    private Double toDoubleValue(String sourceValue){
        Double result = 0.0;
        if (sourceValue != null){
            try {
                result = Double.parseDouble(sourceValue);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public Double getTotalMRC() {
        return totalMRC;
    }

    public PriceItem setTotalMRC(Double totalMRC) {
        if (totalMRC == null) totalMRC = 0.0;
        this.totalMRC = totalMRC;
        return this;
    }

    public Double getTotalNRC() {
        return totalNRC;
    }

    public PriceItem setTotalNRC(Double totalNRC) {
        if (totalNRC == null) totalNRC = 0.0;
        this.totalNRC = totalNRC;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PriceItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigInteger getOfferingId() {
        return offeringId;
    }

    public PriceItem setOfferingId(BigInteger offeringId) {
        this.offeringId = offeringId;
        return this;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public PriceItem setOfferingName(String offeringName) {
        this.offeringName = offeringName;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("offeringId", offeringId)
                .append("offeringName", offeringName)
                .append("totalMRC", totalMRC)
                .append("totalNRC", totalNRC)
                .append("quantity", quantity)
                .toString();
    }
}
