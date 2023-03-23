package com.fouomene.device.model.dto;

import com.fouomene.device.model.entities.StatusDeviceType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDto {
    private Long id;
    private String code;
    private String name;
    private String ip;
    private StatusDeviceType status;
    private AddressDto address;

}