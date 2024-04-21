package com.example.orderservice.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentServiceTest {
    private PaymentService paymentService;

    private PaymentPort paymentPort;


    @BeforeEach
    void setUp() {

        final PaymentGateway paymentGateway = new ConsolePaymentGatewayImpl();
        final PaymentRepository paymentRepository = new PaymentRepository();
        paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    @Test
    void 상품주문() {
        final PaymentRequst request = PaymentSteps.주문결제요청_생성();
        paymentService.payment(request);
    }

}
