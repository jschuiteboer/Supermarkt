package com.yacht.supermarkt;

import com.yacht.supermarkt.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LineItem {
    private Product product;
    private int amount;

    public LineItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public BigDecimal getTotal() {
        BigDecimal productPrice = this.getProduct().getPrice();
        return productPrice.multiply(new BigDecimal(this.getAmount()));
    }

    // TODO: implement
    public BigDecimal getTotalDiscount() {
        return null;
    }
}
