package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.Product;

import java.math.BigDecimal;

public abstract class DiscountRuleDecorator implements DiscountRule {
    protected DiscountRule delegate;

    public DiscountRuleDecorator(DiscountRule delegate) {
        this.delegate = delegate;
    }

    @Override
    public BigDecimal getTotalDiscount(Product product, int amount) {
        return delegate.getTotalDiscount(product, amount);
    }
}
