package com.example.orderservice.product;

import org.springframework.util.Assert;

record GetProductResponse(
        Long id,
        String name,
        int price,
        DiscountPolicy discountPolicy
) {
    public GetProductResponse {
        Assert.notNull(id, "상품 id는 필수입니다.");
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "가격은 0원보다 커야합니다.");
        Assert.notNull(discountPolicy, "정책은 필수입니다.");
    }
}
