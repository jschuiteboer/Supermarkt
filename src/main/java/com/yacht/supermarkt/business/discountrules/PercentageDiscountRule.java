package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class PercentageDiscountRule implements DiscountRule {
    @Getter
    @Setter
    private int percent;

    public PercentageDiscountRule(int percent) {
        this.percent = percent;
    }

    public BigDecimal getTotalDiscount(Product product, int amount) {
        BigDecimal productPrice = product.getPrice().multiply(new BigDecimal(amount));

        BigDecimal multiplier = new BigDecimal(this.getPercent() / 100.0f);

        return productPrice.multiply(multiplier);
    }
}
