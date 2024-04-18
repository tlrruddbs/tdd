package com.example.orderservice.order;

import com.example.orderservice.ApiTest;
import com.example.orderservice.product.DiscountPolicy;
import com.example.orderservice.product.Product;
import com.example.orderservice.product.ProductService;
import com.example.orderservice.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderApiTest extends ApiTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = 상품주문요청_생성();
        ExtractableResponse<Response> response = 상품주문요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

    }

    private static ExtractableResponse<Response> 상품주문요청(CreateOrderRequest request) {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all().extract();
        return response;
    }

    private static CreateOrderRequest 상품주문요청_생성() {
        Long productId = 1L;
        int quantity = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
        return request;
    }

}
