package com.example.orderservice.order.domain;

import com.example.orderservice.product.domain.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private int quantity;


    public Order(final Product product, final int quantity) {
        Assert.notNull(product, "상품이 없습니다.");
        Assert.isTrue(quantity > 0, "상품이 존재하지 않습니다.");
        this.product = product;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return product.getDiscountedPrice()  * quantity;
    }
}
