package com.iki.domain.dto;

import com.iki.domain.entity.OrderMenu;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderMenuResponseDto {
    String orderMenuName;
    int orderMenuPrice;
    int orderMenuAmount;
    List<String> orderMenuOptions;

    @Builder
    public OrderMenuResponseDto(OrderMenu orderMenu, List<String> orderMenuOptions) {
        this.orderMenuName = orderMenu.getMenus().getMenusName();
        this.orderMenuAmount = orderMenu.getAmount();
        this.orderMenuPrice = orderMenu.getPrice();
        this.orderMenuOptions = orderMenuOptions;
    }
}
