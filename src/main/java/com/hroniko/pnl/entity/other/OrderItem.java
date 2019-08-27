package com.hroniko.pnl.entity.other;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderItem {
    private BigInteger id;
    private BigInteger offerId;
    private BigDecimal recurrentIndividualBasicPrice;
    private BigDecimal oneTimeIndividualBasicPrice;

    public BigInteger getId() {
        return id;
    }

    public OrderItem setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public BigInteger getOfferId() {
        return offerId;
    }

    public OrderItem setOfferId(BigInteger offerId) {
        this.offerId = offerId;
        return this;
    }

    public BigDecimal getRecurrentIndividualBasicPrice() {
        return recurrentIndividualBasicPrice;
    }

    public OrderItem setRecurrentIndividualBasicPrice(BigDecimal recurrentIndividualBasicPrice) {
        this.recurrentIndividualBasicPrice = recurrentIndividualBasicPrice;
        return this;
    }

    public BigDecimal getOneTimeIndividualBasicPrice() {
        return oneTimeIndividualBasicPrice;
    }

    public OrderItem setOneTimeIndividualBasicPrice(BigDecimal oneTimeIndividualBasicPrice) {
        this.oneTimeIndividualBasicPrice = oneTimeIndividualBasicPrice;
        return this;
    }
}
