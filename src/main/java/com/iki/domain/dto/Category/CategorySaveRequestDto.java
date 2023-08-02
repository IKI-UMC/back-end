package com.iki.domain.dto.Category;

import com.iki.domain.dto.Menus.MenusSaveRequestDto;
import com.iki.domain.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CategorySaveRequestDto {
    String categoryName;

    public Category toEntity() {
        return Category.builder()
                .categoryName(categoryName)
                .build();
    }
}
