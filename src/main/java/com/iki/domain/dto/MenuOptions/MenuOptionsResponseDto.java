package com.iki.domain.dto.MenuOptions;

import com.iki.domain.entity.MenuOptions;
import lombok.Getter;

@Getter
public class MenuOptionsResponseDto {
    Long menuOptionsId;
    String menusName; // 무슨 메뉴의 옵션인지 알려줌
    boolean isFixed;
    String menuOptionsCategory;
    String menuOptionsContents;
    int menuOptionsPrice;

    public MenuOptionsResponseDto(MenuOptions menuOptions) {
        this.menuOptionsId = menuOptions.getMenuOptionsId();
        this.menusName = menuOptions.getMenus().getMenusName();
        this.isFixed = menuOptions.isFixed();
        this.menuOptionsCategory = menuOptions.getMenuOptionsCategory();
        this.menuOptionsContents = menuOptions.getMenuOptionsContents();
        this.menuOptionsPrice = menuOptions.getMenuOptionsPrice();
    }
}
