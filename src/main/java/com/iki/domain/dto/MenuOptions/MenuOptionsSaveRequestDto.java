package com.iki.domain.dto.MenuOptions;

import com.iki.domain.entity.MenuOptions;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuOptionsSaveRequestDto {
    boolean isFixed;
    String menuOptionsCategory;
    String menuOptionsContents;
    int menuOptionsPrice;

    public MenuOptions toEntity() {
        return MenuOptions.builder()
                .isFixed(isFixed)
                .menuOptionsCategory(menuOptionsCategory)
                .menuOptionsContents(menuOptionsContents)
                .menuOptionsPrice(menuOptionsPrice)
                .build();
    }

}
