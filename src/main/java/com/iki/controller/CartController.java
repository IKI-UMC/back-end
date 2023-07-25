package com.iki.controller;

import com.iki.config.ResponseApiMessage;
import com.iki.domain.dto.Cart.CartResponseDto;
import com.iki.domain.dto.Cart.CartSaveRequestDto;
import com.iki.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController extends BaseController {

    private final static int SUCCESS_CODE = 200;
    private final CartService cartService;

    // 메뉴 한번 클릭 될 때마다 호출
    @PostMapping("/api/v1/cart/")
    public ResponseEntity<ResponseApiMessage> addCart(@RequestBody CartSaveRequestDto requestDto) {
        CartResponseDto responseDto = cartService.save(requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Add to Cart", responseDto);
    }
}
