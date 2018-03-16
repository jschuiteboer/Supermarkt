package com.yacht.supermarkt.business.discountrules;

import com.yacht.supermarkt.model.Product;
import com.yacht.supermarkt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class ProductManager {
    private final static int PAGE_SIZE = 30;

    @Autowired
    private ProductService productService;

    public Page<Product> getPage(int page) {
        return productService.getPage(page, PAGE_SIZE);
    }

    //TODO: move this to a develop env
    @PostConstruct
    private void initSomeTestData() {
        Product product;

        product = new Product();
        product.setName("frikandelbroodje");
        product.setPrice(new BigDecimal("1.23"));
        productService.save(product);

        product = new Product();
        product.setName("pampers");
        product.setPrice(new BigDecimal("9.99"));
        productService.save(product);

        product = new Product();
        product.setName("kipfilet");
        product.setPrice(new BigDecimal("2.40"));
        productService.save(product);

        product = new Product();
        product.setName("ijsthee");
        product.setPrice(new BigDecimal("0.99"));
        productService.save(product);
    }
}
