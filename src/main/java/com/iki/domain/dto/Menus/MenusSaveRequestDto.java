package com.iki.domain.dto.Menus;
import com.iki.domain.dto.MenuOptions.MenuOptionsSaveRequestDto;
import com.iki.domain.entity.Menus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MenusSaveRequestDto {
    String menuCategory;
    String menusName;
    int menusPrice;
    List<MenuOptionsSaveRequestDto> menuOptionsList;

    public Menus toEntity() {
        return Menus.builder()
                .menuCategory(menuCategory)
                .menusName(menusName)
                .menusPrice(menusPrice)
                .build();
    }
}
