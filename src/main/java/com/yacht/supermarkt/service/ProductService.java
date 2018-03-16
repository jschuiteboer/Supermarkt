package com.yacht.supermarkt.service;

import com.yacht.supermarkt.model.Product;
import com.yacht.supermarkt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Page<Product> getPage(int page, int pageSize) {
        return productRepository.findAll(new PageRequest(page, pageSize));
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
