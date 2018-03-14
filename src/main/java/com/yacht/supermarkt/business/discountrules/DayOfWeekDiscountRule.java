package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.LineItem;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.EnumSet;

public class DayOfWeekDiscountRule extends DiscountRuleDecorator {

    @Setter
    private EnumSet<DayOfWeek> enabledDays;

    @Setter
    private DayOfWeek currentDayOfWeek;

    public DayOfWeekDiscountRule(DiscountRule delegate) {
        super(delegate);

        this.enabledDays = EnumSet.noneOf(DayOfWeek.class);
    }

    @Override
    public BigDecimal getTotalDiscount(LineItem lineItem) {
        if(enabledDays.contains(this.currentDayOfWeek)) {
            return this.delegate.getTotalDiscount(lineItem);
        } else {
            return new BigDecimal(0);
        }
    }
}
