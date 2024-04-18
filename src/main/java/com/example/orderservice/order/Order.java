package com.example.orderservice.order;

import com.example.orderservice.product.Product;
import org.springframework.util.Assert;

class Order {
    private final Product product;
    private final int quantity;
    private Long id;

    public Order(final Product product, final int quantity) {
        Assert.notNull(product, "상품이 없습니다.");
        Assert.isTrue(quantity > 0, "상품이 존재하지 않습니다.");
        this.product = product;
        this.quantity = quantity;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
