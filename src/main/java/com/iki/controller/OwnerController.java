package com.iki.controller;

import com.iki.config.ResponseApiMessage;
import com.iki.domain.dto.Owner.OwnerResponseDto;
import com.iki.domain.dto.Owner.OwnerSaveRequestDto;
import com.iki.domain.dto.Owner.OwnerUpdateRequestDto;
import com.iki.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OwnerController extends BaseController {
    private final static int SUCCESS_CODE = 200;
    private final OwnerService ownerService;

    @PostMapping("api/v1/owner")
    public ResponseEntity<ResponseApiMessage> save(@RequestBody OwnerSaveRequestDto requestDto) {
        Long savedOwnersId = ownerService.save(requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Owner saved.", savedOwnersId);
    }

    @GetMapping("api/v1/owner/{ownerId}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long ownerId) {
        OwnerResponseDto responseDto = ownerService.findById(ownerId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Owner loaded. OWNER_ID=" + ownerId, responseDto);
    }

    @GetMapping("api/v1/owner")
    public ResponseEntity<ResponseApiMessage> findAllOwner() {
        List<OwnerResponseDto> responseDtoList = ownerService.findAll();

        return sendResponseHttpByJson(SUCCESS_CODE, "All owners loaded.", responseDtoList);
    }

    @PutMapping("api/v1/owner/{ownerId}")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long ownerId, @RequestBody OwnerUpdateRequestDto requestDto) {
        OwnerResponseDto responseDto = ownerService.update(ownerId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Owner updated. OWNER_ID=" + ownerId, responseDto);
    }

    @DeleteMapping("api/v1/owner/{ownerId}")
    public ResponseEntity<ResponseApiMessage> delete(@PathVariable Long ownerId) {
        Long deletedOwnerId = ownerService.delete(ownerId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Owner deleted. OWNER_ID=" + ownerId, deletedOwnerId);
    }
}