package com.example.orderservice.product;

import org.springframework.util.Assert;

class Product {
    private Long id;
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;


    public Product(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "이름은 필수입니다.");
        Assert.isTrue(price > 0, "가격은 0원 이상입니다.");
        Assert.notNull(discountPolicy, "정책은 필수입니다.");

        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
