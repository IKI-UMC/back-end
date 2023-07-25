package com.iki.domain.dto.Cart;

import com.iki.domain.dto.OrderMenuResponseDto;
import com.iki.domain.entity.OrderUsers;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CartResponseDto {
    Long orderUsersId;
    int totalPrice = 0;
    List<OrderMenuResponseDto> orderMenuResponseDtoList;

    @Builder
    public CartResponseDto(List<OrderMenuResponseDto> orderMenuResponseDtoList, OrderUsers users) {
        this.orderUsersId = users.getOrderUsersId();
        this.orderMenuResponseDtoList = orderMenuResponseDtoList;
        for (OrderMenuResponseDto responseDto : orderMenuResponseDtoList) {
            totalPrice += responseDto.getOrderMenuPrice();
        }
    }
}
