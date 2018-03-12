package com.yacht.supermarkt.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<Product> contents = new ArrayList<Product>();

    public void addProduct(Product product) {
        this.getContents().add(product);
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);

        for(Product product : this.getContents()) {
            total = total.add(product.getPrice());
        }

        return total;
    }
}
