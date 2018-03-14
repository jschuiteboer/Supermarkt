package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.LineItem;
import java.math.BigDecimal;

public interface DiscountRule {
    BigDecimal getTotalDiscount(LineItem lineItem);
}
