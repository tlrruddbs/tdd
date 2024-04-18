package com.example.orderservice.order;

import com.example.orderservice.product.Product;

interface OrderPort {
    Product getProductById(Long productId);

    void save(Order order);
}
