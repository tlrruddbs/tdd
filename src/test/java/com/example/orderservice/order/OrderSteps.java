package com.example.orderservice.order;

import com.example.orderservice.order.application.service.CreateOrderRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class OrderSteps {
    public static ExtractableResponse<Response> 상품주문요청(CreateOrderRequest request) {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all().extract();
        return response;
    }

    public static CreateOrderRequest 상품주문요청_생성() {
        Long productId = 1L;
        int quantity = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
        return request;
    }
}
