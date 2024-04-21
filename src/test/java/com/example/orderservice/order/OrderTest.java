package com.example.orderservice.order;

import com.example.orderservice.product.DiscountPolicy;
import com.example.orderservice.product.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void 가격_계산() {
        final Order order = new Order(new Product("상품명", 2000, DiscountPolicy.NONE), 3);
        final Order order2 = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 3);
        assertThat(order.getTotalPrice()).isEqualTo(6000);
        assertThat(order2.getTotalPrice()).isEqualTo(3000);
    }
}