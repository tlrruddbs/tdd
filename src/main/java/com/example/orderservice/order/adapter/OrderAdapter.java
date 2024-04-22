package com.example.orderservice.order.adapter;

import com.example.orderservice.order.domain.Order;
import com.example.orderservice.order.port.OrderPort;
import com.example.orderservice.product.domain.Product;
import com.example.orderservice.product.adapter.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }
}
