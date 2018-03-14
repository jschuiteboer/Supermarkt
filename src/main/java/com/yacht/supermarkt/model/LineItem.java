package com.yacht.supermarkt.model;

import com.yacht.supermarkt.business.discountrules.DiscountRule;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LineItem {
    private Product product;
    private int amount;
    private DiscountRule discountRule;

    public BigDecimal getSubTotal() {
        BigDecimal productPrice = this.getProduct().getPrice();
        return productPrice.multiply(new BigDecimal(this.getAmount()));
    }

    public BigDecimal getTotalDiscount() {
        return this.getDiscountRule().getTotalDiscount(this);
    }
}
