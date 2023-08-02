package com.iki.service;

import com.iki.domain.dto.Menus.MenusResponseDto;
import com.iki.domain.dto.Menus.MenusSaveRequestDto;
import com.iki.domain.dto.Menus.MenusUpdateRequestDto;
import com.iki.domain.entity.Category;
import com.iki.domain.entity.Menus;
import com.iki.domain.entity.Owner;
import com.iki.repository.CategoryRepository;
import com.iki.repository.MenusRepository;
import com.iki.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MenusService {
    private final MenusRepository menusRepository;
    private final OwnerRepository ownerRepository;
    private final CategoryRepository categoryRepository;

    public Menus findMenus(Long menuId) {
        return menusRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. MENU_ID=" + menuId));
    }

    public Category findCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 없습니다. CATEGORY_ID=" + categoryId));
    }

    public MenusResponseDto findById(Long menusId) { // 사용 X, update return값에 사용하기 위해 남겨둠
        Menus menus = findMenus(menusId);

        return new MenusResponseDto(menus);
    }

    @Transactional
    public Long save(Long categoryId, MenusSaveRequestDto requestDto) {
        Category category = findCategory(categoryId);
        Menus menus = requestDto.toEntity();
        menus.addCategory(category);
        category.addMenus(menus);

        return menusRepository.save(menus).getMenusId();
    }

    @Transactional
    public MenusResponseDto update(Long menusId, MenusUpdateRequestDto requestDto) {
        Menus menus = findMenus(menusId);

        menus.update(requestDto.getMenusName(), requestDto.getMenusPrice(), requestDto.isSoldOut());

        return findById(menusId);
    }

    @Transactional
    public Long delete(Long menusId) {
        Menus menus = findMenus(menusId);
        menusRepository.delete(menus);

        return menusId;
    }

}
