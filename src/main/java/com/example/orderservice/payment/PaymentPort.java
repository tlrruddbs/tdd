package com.example.orderservice.payment;

import com.example.orderservice.order.Order;

interface PaymentPort {
    Order getOrder(Long aLong);

//    void pay(Payment payment);

    void save(Payment payment);

    void pay(int totalPrice, String cardNumber);
}
