package com.iki.domain.dto.MenuOptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuOptionsUpdateRequestDto {
    boolean fixed;
    String menuOptionsCategory;
    String menuOptionsContents;
    int menuOptionsPrice;
}
