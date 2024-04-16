package com.example.orderservice.product;

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


    public Product(final String name,final int price, final DiscountPolicy discountPolicy) {
        Assert.hasText(name, "이름은 필수입니다.");
        Assert.isTrue(price > 0, "가격은 0원 이상입니다.");
        Assert.notNull(discountPolicy, "정책은 필수입니다.");

        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
}
