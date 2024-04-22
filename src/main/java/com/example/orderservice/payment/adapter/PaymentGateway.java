package com.example.orderservice.payment.adapter;

interface PaymentGateway {
    void execute(final int totalPrice, final String cardNumber);
}
