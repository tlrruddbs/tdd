package com.example.orderservice.payment;

import com.example.orderservice.ApiTest;
import com.example.orderservice.order.OrderSteps;
import com.example.orderservice.payment.application.service.PaymentRequst;
import com.example.orderservice.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentApiTest extends ApiTest {


    @Test
    void 상품주문() {

        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        final PaymentRequst request = PaymentSteps.주문결제요청_생성();

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/payments")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
