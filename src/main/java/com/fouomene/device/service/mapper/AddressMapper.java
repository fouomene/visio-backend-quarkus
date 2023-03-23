package com.fouomene.device.service.mapper;

import com.fouomene.device.model.dto.AddressDto;
import com.fouomene.device.model.entities.AddressEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressMapper {
    public AddressEntity toEntity(AddressDto addressDto) {
        return AddressEntity.builder()
                .name(addressDto.getName())
                .lat(addressDto.getLat())
                .lng(addressDto.getLng())
                .build();
    }

    public AddressDto toDto(AddressEntity addressEntity) {
        return AddressDto.builder()
                .id(addressEntity.getId())
                .name(addressEntity.getName())
                .lat(addressEntity.getLat())
                .lng(addressEntity.getLng())
                .build();
    }

    public void copy(AddressDto addressDto, AddressEntity addressEntity) {
        addressEntity.setName(addressDto.getName());
        addressEntity.setLat(addressDto.getLat());
        addressEntity.setLng(addressDto.getLng());
    }
}
