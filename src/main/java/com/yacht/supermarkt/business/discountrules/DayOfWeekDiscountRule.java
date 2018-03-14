package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.Product;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.EnumSet;

public class DayOfWeekDiscountRule extends DiscountRuleDecorator {

    @Setter
    private EnumSet<DayOfWeek> enabledDays;

    private DayOfWeek currentDayOfWeek;

    public DayOfWeekDiscountRule(DiscountRule delegate) {
        super(delegate);
        enabledDays.add(DayOfWeek.MONDAY);
    }

    public void setCurrentDayOfWeek(DayOfWeek currentDayOfWeek) {
        this.currentDayOfWeek = currentDayOfWeek;
    }

    public BigDecimal getTotalDiscount(Product product, int amount) {
        return this.delegate.getTotalDiscount(product, amount);
    }
}
