package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductPort productPort;



    @Test
    void 상품수정() {
        productService.addProduct(ProductSteps.상품등록요청_생성());

        Long productId = 1L;
        UpdateProductRequest request = ProductSteps.상품수정요청_생성();

        productService.updateProduct(productId, request);

        ResponseEntity<GetProductResponse> response = productService.getProduct(productId);

        GetProductResponse productResponse = response.getBody();

        assertThat(productResponse.name()).isEqualTo("상품 수정");
        assertThat(productResponse.price()).isEqualTo(2000);

    }


}
