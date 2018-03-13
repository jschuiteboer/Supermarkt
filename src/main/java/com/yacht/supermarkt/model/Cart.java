package com.yacht.supermarkt.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<LineItem> lineItems = new ArrayList<LineItem>();

    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }

    public BigDecimal getSubTotal() {
        BigDecimal total = new BigDecimal(0);

        for(LineItem lineItem : this.getLineItems()) {
            total = total.add(lineItem.getSubTotal());
        }

        return total;
    }

    public BigDecimal getTotalDiscount() {
        BigDecimal total = new BigDecimal(0);

        for(LineItem lineItem : this.getLineItems()) {
            total = total.add(lineItem.getTotalDiscount());
        }

        return total;
    }

    public BigDecimal getTotal() {
        return this.getSubTotal().subtract(this.getTotalDiscount());
    }
}
