package com.iki.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<OrderMenu> menus = new ArrayList<>();

    private int totalAmount;

    private int totalPrice;

    @Builder
    public Cart() {
        this.totalAmount = 0;
        this.totalPrice = 0;
    }

    public void addMenus(OrderMenu orderMenu) {
        this.menus.add(orderMenu);
    }
}
