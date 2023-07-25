package com.iki.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class OrderMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderMenuId;

    @ManyToOne
    @JoinColumn(name = "menusId")
    private Menus menus;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    private String optionsList;

    private int amount = 0;

    private int price;

    @Builder
    public OrderMenu(Menus menus, String optionsList, int price, Cart cart) {
        this.menus = menus;
        this.optionsList = optionsList;
        this.amount = 1;
        this.price = price;
        this.cart = cart;
    }

    public void addAmount() {
        this.cart.addAmount(1);
        this.cart.addPrice(price);
        this.amount++;
        this.price = price * amount;
    }

    public void minusAmount() {
        this.cart.minusAmount(1);
        this.cart.minusPrice(price);
        this.amount--;
        this.price = price * amount;
    }
}
