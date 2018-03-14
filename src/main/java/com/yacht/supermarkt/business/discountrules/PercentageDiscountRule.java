package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.LineItem;

import java.math.BigDecimal;

public class PercentageDiscountRule implements DiscountRule {
    private int percentage;

    public PercentageDiscountRule(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public BigDecimal getTotalDiscount(LineItem lineItem) {
        BigDecimal subTotal = lineItem.getSubTotal();

        BigDecimal multiplier = new BigDecimal(this.percentage / 100.0f);

        return subTotal.multiply(multiplier);
    }
}
