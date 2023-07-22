package com.iki.service;

import com.iki.domain.dto.MenuOptions.MenuOptionsResponseDto;
import com.iki.domain.dto.MenuOptions.MenuOptionsSaveRequestDto;
import com.iki.domain.dto.MenuOptions.MenuOptionsUpdateRequestDto;
import com.iki.domain.entity.MenuOptions;
import com.iki.domain.entity.Menus;
import com.iki.repository.MenuOptionsRepository;
import com.iki.repository.MenusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuOptionsService {
    private final MenuOptionsRepository menuOptionsRepository;
    private final MenusRepository menusRepository;

    public MenuOptions findMenuOptions(Long menuOptionsId) {
        return menuOptionsRepository.findById(menuOptionsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 옵션이 메뉴에 존재하지 않습니다. MENU_OPTIONS_ID=" + menuOptionsId));

    }

    public Menus findMenus(Long menusId) {
        return menusRepository.findById(menusId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. MENU_ID=" + menusId));
    }

    @Transactional
    public Long save(Long menusId, MenuOptionsSaveRequestDto requestDto) {
        Menus menus = findMenus(menusId);
        MenuOptions menuOptions = requestDto.toEntity();
        menuOptions.addMenus(menus);
        menus.addMenuOptions(menuOptions);

        return menuOptionsRepository.save(menuOptions).getMenuOptionsId();
    }

    public MenuOptionsResponseDto findById(Long menuOptionsId) {
        MenuOptions menuOptions = findMenuOptions(menuOptionsId);

        return new MenuOptionsResponseDto(menuOptions);
    }

    public List<MenuOptionsResponseDto> findAll(Long menusId) {
        List<MenuOptionsResponseDto> menuOptionsResponseDtoList = new ArrayList<>();
        Menus menus = findMenus(menusId);
        List<MenuOptions> menuOptionsList = menus.getMenuOptionsList();

        for(MenuOptions menuOptions : menuOptionsList) {
            menuOptionsResponseDtoList.add(new MenuOptionsResponseDto(menuOptions));
        }

        return menuOptionsResponseDtoList;
    }


    public List<MenuOptionsResponseDto> findFixedOptions(Long menusId) {
        List<MenuOptionsResponseDto> menuOptionsResponseDtoList = new ArrayList<>();
        Menus menus = findMenus(menusId);
        List<MenuOptions> menuOptionsList = menus.getMenuOptionsList();

        for(MenuOptions menuOptions : menuOptionsList) {
            if (menuOptions.isFixed()) {
                menuOptionsResponseDtoList.add(new MenuOptionsResponseDto(menuOptions));
            }
        }

        return menuOptionsResponseDtoList;
    }

    public List<MenuOptionsResponseDto> findNotFixedOptions(Long menusId) {
        List<MenuOptionsResponseDto> menuOptionsResponseDtoList = new ArrayList<>();
        Menus menus = findMenus(menusId);
        List<MenuOptions> menuOptionsList = menus.getMenuOptionsList();

        for(MenuOptions menuOptions : menuOptionsList) {
            if (!menuOptions.isFixed()) {
                menuOptionsResponseDtoList.add(new MenuOptionsResponseDto(menuOptions));
            }
        }

        return menuOptionsResponseDtoList;
    }

    @Transactional
    public MenuOptionsResponseDto update(Long menuOptionsId, MenuOptionsUpdateRequestDto requestDto) {
        MenuOptions menuOptions = findMenuOptions(menuOptionsId);

        menuOptions.update(requestDto.isFixed(), requestDto.getMenuOptionsCategory(), requestDto.getMenuOptionsContents(), requestDto.getMenuOptionsPrice());

        return findById(menuOptionsId);
    }

    @Transactional
    public Long delete(Long menuOptionsId) {
        MenuOptions menuOptions = findMenuOptions(menuOptionsId);
        menuOptionsRepository.delete(menuOptions);

        return menuOptionsId;
    }
}
