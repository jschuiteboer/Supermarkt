package com.yacht.supermarkt;

import com.yacht.supermarkt.model.Cart;
import com.yacht.supermarkt.model.Product;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {

        Product product = new Product();
        product.setName("frikandelbroodje");
        product.setPrice(new BigDecimal("1.23"));
        product.setDiscount(new DiscountRule() {
            public BigDecimal applyDiscount(BigDecimal price) {
                return null;
            }
        });

        Cart cart = new Cart();
        cart.addLineItem(new LineItem(product, 2));

        System.out.println(cart.getTotal());
        System.out.println(cart.getTotalDiscount());
    }
}
