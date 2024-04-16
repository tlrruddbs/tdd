package com.example.orderservice.product;

import com.example.orderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.net.http.HttpResponse;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductApiTest extends ApiTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void 상품등록(){
        final var request = ProductSteps.상품등록요청_생성();

        final var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {
        final var rr = ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());

        Long productId = 1L;

        final var response = ProductSteps.상품조회요청(productId);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");

    }

    @Test
    void 상품수정() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(ProductSteps.상품수정요청())
                .when()
                .patch("/products/{productId}", productId)
                .then()
                .log().all().extract();
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");
    }
}
