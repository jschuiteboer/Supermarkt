package com.yacht.supermarkt;

import java.math.BigDecimal;

public interface DiscountRule {
    BigDecimal applyDiscount(BigDecimal price);
}
