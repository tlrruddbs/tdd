package com.example.orderservice.product;

import org.springframework.util.Assert;

class Product {

    private Long id;

    public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명은 필수");
        Assert.isTrue(price > 0, "0보다 커야함");
        Assert.notNull(discountPolicy, "정책은 필수");
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
