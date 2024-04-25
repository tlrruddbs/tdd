package com.example.orderservice.payment.application.service;

import org.springframework.util.Assert;

public record PaymentRequst(Long orderId, String cardNumber) {
    public PaymentRequst(Long orderId, String cardNumber) {
        Assert.notNull(orderId, "주문 번호는 필수입니다.");
        Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
        this.orderId = orderId;
        this.cardNumber = cardNumber;
    }
}
