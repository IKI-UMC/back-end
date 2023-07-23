package com.iki.domain.dto.Menus;

import com.iki.domain.entity.Menus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenusResponseDto {
    Long menusId;
    String menusName;
    int menusPrice;
    boolean soldOut;

    public MenusResponseDto(Menus menus) {
        this.menusId = menus.getMenusId();
        this.menusName = menus.getMenusName();
        this.menusPrice = menus.getMenusPrice();
        this.soldOut = menus.isSoldOut();
    }
}
