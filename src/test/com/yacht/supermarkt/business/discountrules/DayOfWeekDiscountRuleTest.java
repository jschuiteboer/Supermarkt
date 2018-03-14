package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.LineItem;
import com.yacht.supermarkt.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.EnumSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DayOfWeekDiscountRuleTest {
    @Test
    public void testGetTotalDiscountWhereCurrentDayWithinEnabledDays() throws Exception {
        // Arrange
        BigDecimal expected = new BigDecimal(20);

        LineItem lineItem = new LineItem();

        DiscountRule mockedDiscountRule = mock(DiscountRule.class);
        when(mockedDiscountRule.getTotalDiscount(lineItem)).thenReturn(new BigDecimal(20));

        DayOfWeekDiscountRule dayOfWeekDiscountRule = new DayOfWeekDiscountRule(mockedDiscountRule);
        dayOfWeekDiscountRule.setCurrentDayOfWeek(DayOfWeek.MONDAY);
        dayOfWeekDiscountRule.setEnabledDays(EnumSet.of(DayOfWeek.MONDAY));

        // Act
        BigDecimal result = dayOfWeekDiscountRule.getTotalDiscount(lineItem);

        // Assert
        Assert.assertEquals(result.compareTo(expected), 0);
    }

    @Test
    public void testGetTotalDiscountWhereCurrentDayOutsideEnabledDays() throws Exception {
        // Arrange
        BigDecimal expected = new BigDecimal(0);

        LineItem lineItem = new LineItem();

        DiscountRule mockedDiscountRule = mock(DiscountRule.class);
        when(mockedDiscountRule.getTotalDiscount(lineItem)).thenReturn(new BigDecimal(20));

        DayOfWeekDiscountRule dayOfWeekDiscountRule = new DayOfWeekDiscountRule(mockedDiscountRule);
        dayOfWeekDiscountRule.setCurrentDayOfWeek(DayOfWeek.MONDAY);
        dayOfWeekDiscountRule.setEnabledDays(EnumSet.noneOf(DayOfWeek.class));

        // Act
        BigDecimal result = dayOfWeekDiscountRule.getTotalDiscount(lineItem);

        // Assert
        Assert.assertEquals(result.compareTo(expected), 0);
    }
}