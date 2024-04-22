package com.example.orderservice.payment;

import com.example.orderservice.order.Order;
import com.example.orderservice.order.OrderRepository;
import com.example.orderservice.product.DiscountPolicy;
import com.example.orderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {

    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;

    private final OrderRepository orderRepository;

    PaymentAdapter(final PaymentGateway paymentGateway, final PaymentRepository paymentRepository, final OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(final Long id) {
//        return new Order(new Product("상품", 1000, DiscountPolicy.NONE), 2);
        return orderRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }
}
