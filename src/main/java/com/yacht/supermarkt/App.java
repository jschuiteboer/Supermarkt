package com.yacht.supermarkt;

import com.yacht.supermarkt.model.Cart;
import com.yacht.supermarkt.model.LineItem;
import com.yacht.supermarkt.model.Product;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        Product product = new Product();
        product.setName("frikandelbroodje");
        product.setPrice(new BigDecimal("1.23"));

        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        lineItem.setAmount(2);
        lineItem.setDiscountRule(new DiscountRule() {
            public BigDecimal getTotalDiscount(Product product, int amount) {
                return new BigDecimal(0);
            }
        });

        Cart cart = new Cart();
        cart.addLineItem(lineItem);

        System.out.println(cart.getSubTotal());
        System.out.println(cart.getTotalDiscount());
        System.out.println(cart.getTotal());
    }
}
