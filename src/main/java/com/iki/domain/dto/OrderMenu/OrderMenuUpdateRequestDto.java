package com.iki.domain.dto.OrderMenu;

import lombok.Getter;

@Getter
public class OrderMenuUpdateRequestDto {
    Long orderMenuId;
    int orderMenuPrice;
    int orderMenuAmount;
    boolean deleted;
}
