package com.example.orderservice.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void update() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        //when
        product.update("상품수정", 500, DiscountPolicy.NONE);

        assertThat(product.getName()).isEqualTo("상품수정");
        assertThat(product.getPrice()).isEqualTo(500);
    }
}