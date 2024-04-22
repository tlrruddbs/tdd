package com.example.orderservice.order.application.service;

import org.springframework.util.Assert;

record CreateOrderRequest(Long productId, int quantity) {
    CreateOrderRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        Assert.notNull(productId, "상품 번호는 있어야합니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야합니다.");

    }
}
