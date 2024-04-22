package com.example.orderservice.product;

import com.example.orderservice.product.application.service.GetProductResponse;
import com.example.orderservice.product.application.service.ProductService;
import com.example.orderservice.product.application.service.UpdateProductRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품수정() {
        //상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());

        final Long productId = 1L;
        final UpdateProductRequest request = ProductSteps.상품수정요청();
//        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        productService.updateProduct(productId, request);

        final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        final GetProductResponse productResponse = response.getBody();
        assertThat(productResponse.name()).isEqualTo("상품 수정");
        assertThat(productResponse.price()).isEqualTo(2000);

    }

    //    private static class StubProductPort implements ProductPort {
//        public Product getProduct_will_return;
//
//
//        @Override
//        public void save(Product product) {
//
//        }
//
//        @Override
//        public Product getProduct(Long productId) {
//            return getProduct_will_return;
//        }
//    }
}
