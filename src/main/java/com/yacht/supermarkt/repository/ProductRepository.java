package com.yacht.supermarkt.repository;

import com.yacht.supermarkt.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
