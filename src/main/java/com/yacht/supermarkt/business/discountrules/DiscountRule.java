package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.Product;

import java.math.BigDecimal;

public interface DiscountRule {
    BigDecimal getTotalDiscount(Product product, int amount);
}
