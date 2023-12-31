package com.iki.controller;

import com.iki.config.ResponseApiMessage;
import com.iki.domain.dto.Menus.MenusResponseDto;
import com.iki.domain.dto.Menus.MenusSaveRequestDto;
import com.iki.domain.dto.Menus.MenusUpdateRequestDto;
import com.iki.service.MenusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MenusController extends BaseController {
    private final static int SUCCESS_CODE = 200;
    private final MenusService menusService;

    @PostMapping("api/v1/menus/{categoryId}")
    public ResponseEntity<ResponseApiMessage> save(@PathVariable Long categoryId, @RequestBody MenusSaveRequestDto requestDto) {
        Long savedMenusId = menusService.save(categoryId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Menu saved", savedMenusId);
    }

    @GetMapping("api/v1/menus/{menusId}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long menusId) {
        MenusResponseDto responseDto = menusService.findById(menusId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Menu loaded. MENU_ID=" + menusId, responseDto);
    }

    @PutMapping("api/v1/menus/{menusId}")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long menusId, @RequestBody MenusUpdateRequestDto requestDto) {
        MenusResponseDto responseDto = menusService.update(menusId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Menu has updated. MENU_ID=" + menusId, responseDto);
    }

    @DeleteMapping("api/v1/menus/{menusId}")
    public ResponseEntity<ResponseApiMessage> delete(@PathVariable Long menusId) {
        Long deletedMenusId = menusService.delete(menusId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Menu deleted. MENU_ID=" + menusId, deletedMenusId);
    }
}
