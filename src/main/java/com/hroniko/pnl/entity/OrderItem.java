package com.hroniko.pnl.entity;

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

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getOfferId() {
        return offerId;
    }

    public void setOfferId(BigInteger offerId) {
        this.offerId = offerId;
    }

    public BigDecimal getRecurrentIndividualBasicPrice() {
        return recurrentIndividualBasicPrice;
    }

    public void setRecurrentIndividualBasicPrice(BigDecimal recurrentIndividualBasicPrice) {
        this.recurrentIndividualBasicPrice = recurrentIndividualBasicPrice;
    }

    public BigDecimal getOneTimeIndividualBasicPrice() {
        return oneTimeIndividualBasicPrice;
    }

    public void setOneTimeIndividualBasicPrice(BigDecimal oneTimeIndividualBasicPrice) {
        this.oneTimeIndividualBasicPrice = oneTimeIndividualBasicPrice;
    }
}
