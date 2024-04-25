package com.example.orderservice.product.application.service;

import com.example.orderservice.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public AddProductRequest {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "정책은 필수입니다.");
    }
}
