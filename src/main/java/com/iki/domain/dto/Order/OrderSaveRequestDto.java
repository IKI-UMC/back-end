package com.iki.domain.dto.Order;

import lombok.Getter;

@Getter
public class OrderSaveRequestDto {
    boolean takeOut;
    Long cartId;

}
