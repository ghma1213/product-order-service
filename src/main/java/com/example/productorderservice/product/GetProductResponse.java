package com.example.productorderservice.product;

import org.springframework.util.Assert;

record GetProductResponse(Long id, String name, int price, DiscountPolicy discountPolicy) {
    GetProductResponse {
        Assert.notNull(id, "id는 필수");
        Assert.hasText(name, "상품명 필수");
        Assert.notNull(discountPolicy, "할인 정책 필수");
    }
}
