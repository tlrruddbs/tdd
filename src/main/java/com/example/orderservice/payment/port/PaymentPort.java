package com.example.orderservice.payment.port;

import com.example.orderservice.order.domain.Order;
import com.example.orderservice.payment.domain.Payment;

interface PaymentPort {
    Order getOrder(Long aLong);

//    void pay(Payment payment);

    void save(Payment payment);

    void pay(int totalPrice, String cardNumber);
}
