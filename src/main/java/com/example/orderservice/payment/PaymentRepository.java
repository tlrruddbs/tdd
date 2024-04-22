package com.example.orderservice.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

interface PaymentRepository extends JpaRepository<Payment, Long> {
}
