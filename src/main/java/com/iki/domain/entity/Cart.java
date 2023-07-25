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
        this.totalAmount += orderMenu.getAmount();
        this.totalPrice += orderMenu.getPrice();
        this.menus.add(orderMenu);
    }

    public void addAmount(int amount) {
        this.totalAmount += amount;
    }

    public void addPrice(int price) {
        this.totalPrice += price;
    }

    public void minusAmount(int amount) {
        this.totalAmount -= amount;
    }

    public void minusPrice(int price) {
        this.totalPrice -= price;
    }
}
