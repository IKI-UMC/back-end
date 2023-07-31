package com.iki.domain.dto.Order;

import com.iki.domain.entity.Cart;
import com.iki.domain.entity.Customer;
import com.iki.domain.entity.Orders;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderResponseDto {
    Long OrderId;
    boolean takeOut;
    int totalPrice;

    public OrderResponseDto(Orders orders) {
        this.OrderId = orders.getOrderId();
        this.takeOut = orders.isTakeOut();
        this.totalPrice = orders.getTotalPrice();
    }
}
