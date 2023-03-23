package com.fouomene.device.service.mapper;

import com.fouomene.device.model.dto.DeviceDto;
import com.fouomene.device.model.entities.DeviceEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class DeviceMapper {


    private final AddressMapper addressMapper;

    public DeviceEntity toEntity(DeviceDto deviceDto) {
        return DeviceEntity.builder()
                .code(deviceDto.getCode())
                .name(deviceDto.getName())
                .ip(deviceDto.getIp())
                .status(deviceDto.getStatus())
                .addressEntity(addressMapper.toEntity(deviceDto.getAddress()))
                .build();
    }

    public DeviceDto toDto(DeviceEntity deviceEntity) {
        return DeviceDto.builder()
                .id(deviceEntity.getId())
                .code(deviceEntity.getCode())
                .ip(deviceEntity.getIp())
                .name(deviceEntity.getName())
                .status(deviceEntity.getStatus())
                .address(addressMapper.toDto(deviceEntity.getAddressEntity()))
                .build();
    }

    public void copy(DeviceDto deviceDto, DeviceEntity deviceEntity) {
        deviceEntity.setIp(deviceDto.getIp());
        deviceEntity.setName(deviceDto.getName());
        deviceEntity.setStatus(deviceDto.getStatus());
        deviceEntity.setAddressEntity(addressMapper.toEntity(deviceDto.getAddress()));
    }
}
