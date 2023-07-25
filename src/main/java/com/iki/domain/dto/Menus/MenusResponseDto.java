package com.iki.domain.dto.Menus;

import com.iki.domain.dto.MenuOptions.MenuOptionsResponseDto;
import com.iki.domain.entity.MenuOptions;
import com.iki.domain.entity.Menus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class MenusResponseDto {
    Long menusId;
    String menusCategory;
    String menusName;
    int menusPrice;
    boolean soldOut;
    List<MenuOptionsResponseDto> menuOptionsList;

    public MenusResponseDto(Menus menus) {
        this.menusId = menus.getMenusId();
        this.menusCategory = menus.getMenusCategory();
        this.menusName = menus.getMenusName();
        this.menusPrice = menus.getMenusPrice();
        this.soldOut = menus.isSoldOut();
        this.menuOptionsList = new ArrayList<>();
        List<MenuOptions> menuOptions = menus.getMenuOptionsList();
        if(menuOptions != null) {
            for (MenuOptions allMenuOptions : menuOptions) {
                this.menuOptionsList.add(new MenuOptionsResponseDto(allMenuOptions));
            }
        }
    }
}
