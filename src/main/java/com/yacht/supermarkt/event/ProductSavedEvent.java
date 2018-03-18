package com.yacht.supermarkt.event;

import com.yacht.supermarkt.model.Product;
import org.springframework.context.ApplicationEvent;

public class ProductSavedEvent extends ApplicationEvent {
    public ProductSavedEvent(Product product) {
        super(product);
    }

    public Product getProduct() {
        return (Product) this.getSource();
    }
}
