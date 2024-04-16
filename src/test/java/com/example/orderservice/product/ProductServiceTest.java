package com.example.orderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Test
    void 상품조회() {
        //상품 등록
//        productService.addProduct(ProductSteps.상품등록요청_생성());
//
//        final Long productId = 1L;
//
//        final GetProductResponse response = productService.getProduct(productId);
//
//        assertThat(response).isNotNull();
    }


}
