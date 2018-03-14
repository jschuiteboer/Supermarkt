package com.yacht.supermarkt.repository;

import com.yacht.supermarkt.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    private static List<Product> products = Arrays.asList(
            new Product(0L, "frikandelbroodje", new BigDecimal("1.23")),
            new Product(1L, "pampers", new BigDecimal("9.99")),
            new Product(2L, "kipfilet", new BigDecimal("2.40")),
            new Product(3L, "ijsthee", new BigDecimal("0.99"))
    );

    public Product getById(Long id) {
        for(Product product : products) {
            if(product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }
}
