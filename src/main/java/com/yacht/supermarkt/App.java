package com.yacht.supermarkt;

import com.yacht.supermarkt.model.Cart;
import com.yacht.supermarkt.model.CashRegister;
import com.yacht.supermarkt.model.Discount;
import com.yacht.supermarkt.model.Product;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        CashRegister kassa = new CashRegister();

        Cart cart = new Cart();

        Product a = new Product();
        a.setName("frikandelbroodje");
        a.setPrice(new BigDecimal("1.23"));
        a.setDiscount(new Discount());
        cart.addProduct(a);

        System.out.print(cart.getTotal());
    }
}
