package com.iki.controller;

import com.iki.config.ResponseApiMessage;
import com.iki.domain.dto.MenuOptions.MenuOptionsResponseDto;
import com.iki.domain.dto.MenuOptions.MenuOptionsSaveRequestDto;
import com.iki.domain.dto.MenuOptions.MenuOptionsUpdateRequestDto;
import com.iki.service.MenuOptionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Log4j2
public class MenuOptionsController extends BaseController {
    private final static int SUCCESS_CODE = 200;
    private final MenuOptionsService menuOptionsService;

    @PostMapping("api/v1/menuoptions/{menusId}")
    public ResponseEntity<ResponseApiMessage> save(@PathVariable Long menusId, @RequestBody MenuOptionsSaveRequestDto requestDto) {
        Long savedMenuOptionsId = menuOptionsService.save(menusId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Option saved", savedMenuOptionsId);
    }

    @GetMapping("api/v1/menuoptions/{menuOptionsId}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long menuOptionsId) {
        MenuOptionsResponseDto responseDto = menuOptionsService.findById(menuOptionsId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Option loaded. OPTION_ID=" + menuOptionsId, responseDto);
    }

    @GetMapping("api/v1/menuoptions/all/{menusId}")
    public ResponseEntity<ResponseApiMessage> findAllOptions(@PathVariable Long menusId) {
        List<MenuOptionsResponseDto> responseDtoList = menuOptionsService.findAll(menusId);

        return sendResponseHttpByJson(SUCCESS_CODE, "All Options loaded", responseDtoList);
    }

    @GetMapping("api/v1/menuoptions/fixed/{menusId}")
    public ResponseEntity<ResponseApiMessage> findFixedOptions(@PathVariable Long menusId) {
        List<MenuOptionsResponseDto> responseDtoList = menuOptionsService.findFixedOptions(menusId);

        return sendResponseHttpByJson(SUCCESS_CODE, "All Fixed Options loaded", responseDtoList);
    }

    @GetMapping("api/v1/menuoptions/notfixed/{menusId}")
    public ResponseEntity<ResponseApiMessage> findNotFixedOptions(@PathVariable Long menusId) {
        List<MenuOptionsResponseDto> responseDtoList = menuOptionsService.findNotFixedOptions(menusId);

        return sendResponseHttpByJson(SUCCESS_CODE, "All Non-fixed Options loaded", responseDtoList);
    }

    @PutMapping("api/v1/menuoptions/{menuOptionsId}")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long menuOptionsId, @RequestBody MenuOptionsUpdateRequestDto requestDto) {
        MenuOptionsResponseDto responseDto = menuOptionsService.update(menuOptionsId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Option updated. OPTION_ID=" + menuOptionsId, responseDto);
    }

    @DeleteMapping("api/v1/menuoptions/{menuOptionsId}")
    public ResponseEntity<ResponseApiMessage> delete(@PathVariable Long menuOptionsId) {
        Long deletedMenuOptionsId = menuOptionsService.delete(menuOptionsId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Option deleted. OPTION_ID=" + menuOptionsId, deletedMenuOptionsId);
    }


}
