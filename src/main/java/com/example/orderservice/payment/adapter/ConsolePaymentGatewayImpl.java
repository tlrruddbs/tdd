package com.example.orderservice.payment.adapter;

import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGatewayImpl implements PaymentGateway {

    @Override
    public void execute(final int totalPrice, final String cardNumber) {
        System.out.println("결제 완료");
    }
}
