package com.example.orderservice.product;

import org.springframework.util.Assert;

record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    UpdateProductRequest {
        Assert.hasText(name, "이름은 필수입니다.");
        Assert.isTrue(price > 0, "0원보다는 높아야합니다.");
        Assert.notNull(discountPolicy, "정책은 필수입니다.");
    }
    }
