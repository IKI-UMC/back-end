package com.iki.domain.dto.Menus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenusUpdateRequestDto {
    String menusCategory;
    String menusName;
    int menusPrice;
    boolean soldOut;
}
