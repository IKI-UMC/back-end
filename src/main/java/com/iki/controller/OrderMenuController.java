package com.iki.controller;

import com.iki.config.ResponseApiMessage;
import com.iki.domain.dto.Cart.CartResponseDto;
import com.iki.service.OrderMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderMenuController extends BaseController {

    private final static int SUCCESS_CODE = 200;
    private final OrderMenuService orderMenuService;

    @PutMapping("/api/v1/orderMenu/{orderMenuId}/addAmount")
    public ResponseEntity<ResponseApiMessage> addOrderMenuAmount(@PathVariable Long orderMenuId) {
        orderMenuService.addOrderMenu(orderMenuId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Add menu amount", orderMenuId);
    }

    @PutMapping("/api/v1/orderMenu/{orderMenuId}/minusAmount")
    public ResponseEntity<ResponseApiMessage> minusOrderMenuAmount( @PathVariable Long orderMenuId) {
        orderMenuService.minusOrderMenu(orderMenuId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Minus menu amount", orderMenuId);
    }

    @DeleteMapping("/api/v1/orderMenu/{orderMenuId}")
    public ResponseEntity<ResponseApiMessage> deleteOrderMenu(@PathVariable Long orderMenuId) {
        Long id = orderMenuService.delete(orderMenuId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Delete order menu", id);
    }
}
