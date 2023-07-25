package com.iki.service;

import com.iki.domain.dto.MenuOptions.MenuOptionsSaveRequestDto;
import com.iki.domain.dto.Menus.MenusResponseDto;
import com.iki.domain.dto.Menus.MenusSaveRequestDto;
import com.iki.domain.dto.Menus.MenusUpdateRequestDto;
import com.iki.domain.entity.Menus;
import com.iki.domain.entity.Owner;
import com.iki.repository.MenuOptionsRepository;
import com.iki.repository.MenusRepository;
import com.iki.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MenusService {
    private final MenusRepository menusRepository;
    private final OwnerRepository ownerRepository;

    private final MenuOptionsService menuOptionsService;

    public Menus findMenus(Long menuId) {
        return menusRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. MENU_ID=" + menuId));
    }

    public Owner findOwner(Long ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 관리자가 없습니다. OWNER_ID=" + ownerId));
    }

    @Transactional
    public Long save(Long ownerId, MenusSaveRequestDto requestDto) {
        Owner owner = findOwner(ownerId);
        Menus menus = requestDto.toEntity();
        menus.addOwner(owner);
        owner.addMenus(menus);

        // 메뉴 저장
        menusRepository.save(menus);

        // 메뉴에 포함된 옵션 저장
        for (MenuOptionsSaveRequestDto menuOptionsSaveRequestDto : requestDto.getMenuOptionsList()) {
            menuOptionsService.save(menus.getMenusId(), menuOptionsSaveRequestDto);
        }

        return menus.getMenusId();
    }

    public MenusResponseDto findById(Long menusId) {
        Menus menus = findMenus(menusId);

        return new MenusResponseDto(menus);
    }

    public List<MenusResponseDto> findAll(Long ownerId) {
        List<MenusResponseDto> menusResponseDtoList = new ArrayList<>();
        Owner owner = findOwner(ownerId);
        List<Menus> menusList = owner.getMenusList();

        for(Menus menus : menusList) {
            menusResponseDtoList.add(new MenusResponseDto(menus));
        }

        return menusResponseDtoList;
    }

    @Transactional
    public MenusResponseDto update(Long menusId, MenusUpdateRequestDto requestDto) {
        Menus menus = findMenus(menusId);

        menus.update(requestDto.getMenuCategory(), requestDto.getMenusName(), requestDto.getMenusPrice(), requestDto.isSoldOut());

        return findById(menusId);
    }

    @Transactional
    public Long delete(Long menusId) {
        Menus menus = findMenus(menusId);
        menusRepository.delete(menus);

        return menusId;
    }

}
