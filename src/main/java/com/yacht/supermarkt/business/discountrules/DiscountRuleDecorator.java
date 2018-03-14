package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.LineItem;
import java.math.BigDecimal;

public abstract class DiscountRuleDecorator implements DiscountRule {
    protected DiscountRule delegate;

    DiscountRuleDecorator(DiscountRule delegate) {
        this.delegate = delegate;
    }

    @Override
    public BigDecimal getTotalDiscount(LineItem lineItem) {
        return delegate.getTotalDiscount(lineItem);
    }
}
