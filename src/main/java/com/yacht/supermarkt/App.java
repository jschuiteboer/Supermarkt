package com.yacht.supermarkt;

import com.yacht.supermarkt.business.discountrules.DayOfWeekDiscountRule;
import com.yacht.supermarkt.business.discountrules.PercentageDiscountRule;
import com.yacht.supermarkt.model.Cart;
import com.yacht.supermarkt.model.LineItem;
import com.yacht.supermarkt.model.Product;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;

public class App {
    public static void main(String[] args) {
        Product product = new Product();
        product.setName("frikandelbroodje");
        product.setPrice(new BigDecimal("1.23"));

        DayOfWeekDiscountRule discountRule = new DayOfWeekDiscountRule(new PercentageDiscountRule(35));
        discountRule.setEnabledDays(EnumSet.of(DayOfWeek.WEDNESDAY));
        discountRule.setCurrentDayOfWeek(LocalDate.now().getDayOfWeek());

        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        lineItem.setAmount(2);
        lineItem.setDiscountRule(discountRule);

        Cart cart = new Cart();
        cart.addLineItem(lineItem);

        System.out.println(cart.getSubTotal());
        System.out.println(cart.getTotalDiscount());
        System.out.println(cart.getTotal());
    }
}
