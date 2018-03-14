package com.yacht.supermarkt;

import com.yacht.supermarkt.repository.ProductRepository;
import com.yacht.supermarkt.business.discountrules.DayOfWeekDiscountRule;
import com.yacht.supermarkt.business.discountrules.PercentageDiscountRule;
import com.yacht.supermarkt.model.Cart;
import com.yacht.supermarkt.model.LineItem;
import com.yacht.supermarkt.model.Product;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;

public class App {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.getById(0L);

        DayOfWeekDiscountRule discountRule = new DayOfWeekDiscountRule(new PercentageDiscountRule(35));
        discountRule.setEnabledDays(EnumSet.of(DayOfWeek.WEDNESDAY));
        discountRule.setCurrentDayOfWeek(LocalDate.now().getDayOfWeek());

        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        lineItem.setAmount(2);
        lineItem.setDiscountRule(discountRule);

        Cart cart = new Cart();
        cart.addLineItem(lineItem);

        System.out.println(String.format("Cart subtotal: € %.2f", cart.getSubTotal()));
        System.out.println(String.format("Cart discount: € %.2f", cart.getTotalDiscount()));
        System.out.println(String.format("Cart total: € %.2f", cart.getTotal()));
    }
}
