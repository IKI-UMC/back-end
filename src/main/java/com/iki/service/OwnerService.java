package com.iki.service;

import com.iki.domain.dto.Owner.OwnerResponseDto;
import com.iki.domain.dto.Owner.OwnerSaveRequestDto;
import com.iki.domain.dto.Owner.OwnerUpdateRequestDto;
import com.iki.domain.entity.Owner;
import com.iki.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public Owner findOwner(Long ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 관리자가 없습니다. OWNER_ID=" + ownerId));
    }

    @Transactional
    public Long save(OwnerSaveRequestDto requestDto) {
        Owner owner = requestDto.toEntity();

        return ownerRepository.save(owner).getOwnerId();
    }

    public OwnerResponseDto findById(Long ownerId) {
        Owner owner = findOwner(ownerId);

        return new OwnerResponseDto(owner);
    }

    public List<OwnerResponseDto> findAll() {
        List<OwnerResponseDto> ownerResponseDtoList = new ArrayList<>();
        List<Owner> ownerList = ownerRepository.findAll();

        for(Owner owner : ownerList) {
            ownerResponseDtoList.add(new OwnerResponseDto(owner));
        }

        return ownerResponseDtoList;
    }

    @Transactional
    public OwnerResponseDto update(Long ownerId, OwnerUpdateRequestDto requestDto) {
        Owner owner = findOwner(ownerId);

        owner.update(requestDto.getShopName(), requestDto.getPassword());

        return findById(ownerId);
    }

    @Transactional
    public Long delete(Long ownerId) {
        Owner owner = findOwner(ownerId);
        ownerRepository.delete(owner);

        return ownerId;
    }
}
