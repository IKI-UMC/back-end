package com.iki.domain.dto.Cart;

import com.iki.domain.dto.OrderMenu.OrderMenuUpdateRequestDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CartUpdateRequestDto {

    Long cartId;
    List<OrderMenuUpdateRequestDto> orderMenuUpdateRequestDtoList;

}
