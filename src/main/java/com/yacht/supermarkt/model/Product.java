package com.yacht.supermarkt.model;

import com.yacht.supermarkt.DiscountRule;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String name;
    private BigDecimal price;
    private DiscountRule discount;
}
