package com.example.orderservice.product.adapter;

import com.example.orderservice.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}