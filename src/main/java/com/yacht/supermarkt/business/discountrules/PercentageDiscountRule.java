package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.Product;

import java.math.BigDecimal;

public class PercentageDiscountRule implements DiscountRule {
    private int percentage;

    public PercentageDiscountRule(int percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getTotalDiscount(Product product, int amount) {
        BigDecimal productPrice = product.getPrice().multiply(new BigDecimal(amount));

        BigDecimal multiplier = new BigDecimal(this.percentage / 100.0f);

        return productPrice.multiply(multiplier);
    }
}
