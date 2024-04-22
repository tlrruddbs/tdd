package com.example.orderservice.order.port;

import com.example.orderservice.order.domain.Order;
import com.example.orderservice.product.domain.Product;

interface OrderPort {
    Product getProductById(Long productId);

    void save(Order order);
}
