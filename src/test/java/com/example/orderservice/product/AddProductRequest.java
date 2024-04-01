package com.example.orderservice.product;

import org.springframework.util.Assert;

record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {

    AddProductRequest(final String name, final int price, final DiscountPolicy discountPolicy) {
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;

        Assert.hasText(name, "상품명");
        Assert.isTrue(price > 0, "상품명은 0원보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
