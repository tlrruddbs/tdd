package com.example.orderservice.payment;

interface PaymentGateway {
    void execute(final int totalPrice, final String cardNumber);
}
