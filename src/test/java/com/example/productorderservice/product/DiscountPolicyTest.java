package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiscountPolicyTest {

    @Test
    void nonDiscountPolicy() {
        int price = 1000;
        int discountedPrice = DiscountPolicy.NONE.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(price);
    }

    @Test
    void fixDiscountPolicy() {
        int price = 2000;
        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void overDiscountPolicy() {
        int price = 500;
        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(0);
    }
}