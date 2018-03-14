package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.LineItem;
import com.yacht.supermarkt.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PercentageDiscountRuleTest {
    @Test
    public void testGetTotalDiscount() {
        // Arrange
        PercentageDiscountRule percentageDiscountRule = new PercentageDiscountRule(25);

        LineItem lineItem = new LineItem();
        Product product = new Product();
        product.setPrice(new BigDecimal(20));
        lineItem.setProduct(product);
        lineItem.setAmount(2);
        BigDecimal expected = new BigDecimal(10);

        // Act
        BigDecimal result = percentageDiscountRule.getTotalDiscount(lineItem);

        // Assert
        Assert.assertEquals(0, expected.compareTo(result));
    }
}
