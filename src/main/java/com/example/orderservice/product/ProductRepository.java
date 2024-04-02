package com.example.orderservice.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
class ProductRepository {
    private Long sequence = 0L;
    Map<Long, Product> persistence = new HashMap<>();

    public void save(Product product) {
        product.assignId(++sequence);

        persistence.put(product.getId(), product);
    }
}
