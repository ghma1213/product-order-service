package com.example.productorderservice.order;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class OrderApiTest extends ApiTest {


    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        CreateOrderRequest request = OrderSteps.상품주문요청_생성();

        var response = OrderSteps.상품주문요청(request);
        int a = 11;
        String s = String.valueOf(a);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }


}
