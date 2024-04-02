package com.example.orderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;

    private ProductRepository productRepository;


    @BeforeEach
    void setUp() {
        productService = new ProductService();
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
    }

    @Test
    void 상품등록() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        productService.addProduct(request);
    }

    private record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
        private AddProductRequest {
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "가격은 0보다 커야합니다.");
            Assert.notNull(discountPolicy, "정책은 필수입니다.");
        }
    }

    private enum DiscountPolicy {
        NONE
    }

    private class ProductService {

        public void addProduct(AddProductRequest request) {
            final Product product = new Product(request.name, request.price, request.discountPolicy);
            productPort.save(product);
        }
    }

    private class Product {
        private Long id;
        private final String name;
        private final int price;
        private final DiscountPolicy discountPolicy;


        public Product(String name, int price, DiscountPolicy discountPolicy) {
            Assert.hasText(name, "이름은 필수입니다.");
            Assert.isTrue(price>0, "가격은 0원 이상입니다.");
            Assert.notNull(discountPolicy, "정책은 필수입니다.");

            this.name = name;
            this.price = price;
            this.discountPolicy = discountPolicy;
        }

        public void assignId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    private interface ProductPort {
        void save(final Product product);
    }

    private class ProductAdapter implements ProductPort {
        private final ProductRepository productRepository;

        private ProductAdapter(final ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(final Product product) {
            productRepository.save(product);
        }
    }

    private class ProductRepository {
        private Long sequence = 0L;
        Map<Long, Product> persistence = new HashMap<>();

        public void save(Product product) {
            product.assignId(++sequence);

            persistence.put(product.getId(), product);
        }
    }
}
