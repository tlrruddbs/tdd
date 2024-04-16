package com.example.orderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private ProductService productService;
    private StubProductPort productPort = new StubProductPort();

    @BeforeEach
    void setUp() {
        Mockito.mock(productPort)
        productService = new ProductService(productPort);
    }

    //    @Autowired
//    private ProductService productService;
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

    @Test
    void 상품수정() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);



        productPort.getProduct_will_return = product;


        productService.updateProduct(productId, request);

        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
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
