package com.example.orderservice.payment;

public class PaymentSteps {
    public static PaymentRequst 주문결제요청_생성() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        return new PaymentRequst(orderId, cardNumber);
    }
}