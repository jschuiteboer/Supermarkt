package com.yacht.supermarkt.controller;

import com.yacht.supermarkt.business.discountrules.DayOfWeekDiscountRule;
import com.yacht.supermarkt.business.discountrules.PercentageDiscountRule;
import com.yacht.supermarkt.model.Cart;
import com.yacht.supermarkt.model.LineItem;
import com.yacht.supermarkt.model.Product;
import com.yacht.supermarkt.repository.IProductRepository;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;

@FXMLController
public class MainController {

    @Autowired
    IProductRepository productRepository;

    public void initialize() {
        Product product;

        product = new Product();
        product.setName("frikandelbroodje");
        product.setPrice(new BigDecimal("1.23"));
        productRepository.save(product);

        product = new Product();
        product.setName("pampers");
        product.setPrice(new BigDecimal("9.99"));
        productRepository.save(product);

        product = new Product();
        product.setName("kipfilet");
        product.setPrice(new BigDecimal("2.40"));
        productRepository.save(product);

        product = new Product();
        product.setName("ijsthee");
        product.setPrice(new BigDecimal("0.99"));
        productRepository.save(product);

        product = productRepository.findOne(1L);

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

    @FXML
    private void onButtonClicked(final Event event) {
        Product product = new Product();
        product.setName("testProduct");
        product.setPrice(new BigDecimal("1.546"));
        productRepository.save(product);

        System.out.println("\nProducts:");

        productRepository.findAll().forEach(System.out::println);
    }
}
