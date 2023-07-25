package com.iki.service;

import com.iki.domain.entity.*;
import com.iki.repository.MenuOptionsRepository;
import com.iki.repository.MenusRepository;
import com.iki.repository.OrderMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderMenuService {
    private final MenusRepository menusRepository;
    private final MenuOptionsRepository menuOptionsRepository;
    private final OrderMenuRepository orderMenuRepository;


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
    public void addOrderMenu(Long orderMenuId) {
        OrderMenu orderMenu = findOrderMenu(orderMenuId);

        orderMenu.addAmount();
    }

    @Transactional
    public void minusOrderMenu(Long orderMenuId) {
        OrderMenu orderMenu = findOrderMenu(orderMenuId);

        orderMenu.minusAmount();
    }

    @Transactional
    public Long delete(Long orderMenuId) {
        OrderMenu orderMenu = findOrderMenu(orderMenuId);

        orderMenu.getCart().minusPrice(orderMenu.getPrice());
        orderMenu.getCart().minusAmount(orderMenu.getAmount());

        orderMenuRepository.delete(orderMenu);

        return orderMenuId;
    }
}
