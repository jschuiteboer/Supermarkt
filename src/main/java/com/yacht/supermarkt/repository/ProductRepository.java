package com.yacht.supermarkt.repository;

import com.yacht.supermarkt.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
