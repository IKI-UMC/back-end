package com.iki.service;

import com.iki.domain.dto.Cart.CartResponseDto;
import com.iki.domain.dto.OrderMenuResponseDto;
import com.iki.domain.entity.*;
import com.iki.repository.MenuOptionsRepository;
import com.iki.repository.MenusRepository;
import com.iki.repository.OrderMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderMenuService {
    private final MenusRepository menusRepository;
    private final MenuOptionsRepository menuOptionsRepository;
    private final OrderMenuRepository orderMenuRepository;

    private final OrderUsersService orderUsersService;


    private Menus findMenus(Long menusId) {
        return menusRepository.findById(menusId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. MENUS_ID=" + menusId));
    }

    private MenuOptions findMenuOptions(Long menuOptionsId) {
        return menuOptionsRepository.findById(menuOptionsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴 옵션이 없습니다. MENU_OPTIONS_ID=" + menuOptionsId));
    }

    private OrderMenu findOrderMenu(Long orderMenuId) {
        return orderMenuRepository.findById(orderMenuId)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문 메뉴가 없습니다. ORDER_MENU_ID=" + orderMenuId));
    }

    private OrderUsers findOrderUsers(Long orderUsersId) {
        return orderUsersService.findById(orderUsersId);
    }

    @Transactional
    public OrderMenu getOrderMenu(Long menusId, String menuOptions, Cart cart) {
        Menus menus = findMenus(menusId);

        OrderMenu orderMenu = OrderMenu.builder()
                .cart(cart)
                .optionsList(menuOptions)
                .menus(menus)
                .price(getPrice(menus, menuOptions))
                .build();

        return orderMenuRepository.save(orderMenu);
    }

    int getPrice(Menus menus, String optionsList) {
        int price = menus.getMenusPrice();
        String[] options = optionsList.split(",");

        for (String option : options) {
            Long optionsId = Long.parseLong(option);
            price += findMenuOptions(optionsId).getMenuOptionsPrice();
        }

        return price;
    }

    @Transactional
    public CartResponseDto addOrderMenu(Long orderUsersId, Long orderMenuId) {
        OrderMenu orderMenu = findOrderMenu(orderMenuId);

        orderMenu.addAmount();

        return getCartResponseDto(orderUsersId);
    }

    @Transactional
    public CartResponseDto minusOrderMenu(Long orderUsersId, Long orderMenuId) {
        OrderMenu orderMenu = findOrderMenu(orderMenuId);

        orderMenu.minusAmount();

        return getCartResponseDto(orderUsersId);
    }

    public CartResponseDto getCartResponseDto(Long orderUsersId) {
        OrderUsers users = findOrderUsers(orderUsersId);
        Cart cart = users.getCart();
        List<OrderMenu> menus = cart.getMenus();
        List<OrderMenuResponseDto> menuResponseDtoList = new ArrayList<>();

        // 장바구니에 있는 메뉴 개수 만큼 OrderMenuResponseDto 만들어서 넣기
        for (OrderMenu orderMenu : menus) {
            List<String> orderMenuOptions = getOrderMenuOptions(orderMenu.getOptionsList());
            OrderMenuResponseDto responseDto = OrderMenuResponseDto.builder()
                    .orderMenuOptions(orderMenuOptions)
                    .orderMenu(orderMenu)
                    .build();

            menuResponseDtoList.add(responseDto);
        }

        return CartResponseDto.builder()
                .orderMenuResponseDtoList(menuResponseDtoList)
                .users(users)
                .build();
    }

    public List<String> getOrderMenuOptions(String options) {
        String[] optionsIds = options.split(",");
        List<String> optionsNames = new ArrayList<>();

        for (String option : optionsIds) {
            Long optionsId = Long.parseLong(option);
            optionsNames.add(findMenuOptions(optionsId).getMenuOptionsContents());
        }

        return optionsNames;
    }
}
