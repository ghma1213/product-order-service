package com.example.productorderservice.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    public Product(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상풍명은 필수");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야함");
        Assert.notNull(discountPolicy, "할인 정책은 필수");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void update(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상풍명은 필수");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야함");
        Assert.notNull(discountPolicy, "할인 정책은 필수");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public int getDiscountedPrice() {
        return discountPolicy.applyDiscount(price);
    }
}
