package com.iki.service;

import com.iki.domain.dto.Cart.CartResponseDto;
import com.iki.domain.dto.Cart.CartSaveRequestDto;
import com.iki.domain.dto.OrderMenuResponseDto;
import com.iki.domain.entity.*;
import com.iki.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;

    private final OrderUsersService orderUsersService;

    private final MenusRepository menusRepository;
    private final MenuOptionsRepository menuOptionsRepository;
    private final OrderMenuService orderMenuService;


    private Menus findMenus(Long menusId) {
        return menusRepository.findById(menusId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. MENUS_ID=" + menusId));
    }

    private MenuOptions findMenuOptions(Long menuOptionsId) {
        return menuOptionsRepository.findById(menuOptionsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴 옵션이 없습니다. MENU_OPTIONS_ID=" + menuOptionsId));
    }

    private OrderUsers findOrderUsers(Long orderUsersId) {
        return orderUsersService.findById(orderUsersId);
    }

    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    // 메뉴 클릭할 때마다 호출된다.
    @Transactional
    public CartResponseDto save(CartSaveRequestDto requestDto) {
        Cart cart;
        OrderUsers orderUsers;

        if (requestDto.getOrderUsersId() == null) {
            cart = Cart.builder().build();
            saveCart(cart);
            orderUsers = orderUsersService.save(cart);
        } else {
            orderUsers = findOrderUsers(requestDto.getOrderUsersId());
            cart = orderUsers.getCart();
        }

        // 카트에 메뉴 담기
        OrderMenu orderMenu = orderMenuService.getOrderMenu(requestDto.getMenusId(), requestDto.getMenusOptions(), cart);
        cart.addMenus(orderMenu);

        return getCartResponseDto(cart, orderUsers);
    }

    public CartResponseDto getCartResponseDto(Cart cart, OrderUsers users) {
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
