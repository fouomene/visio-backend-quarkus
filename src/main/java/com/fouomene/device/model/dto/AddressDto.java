package com.fouomene.device.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
    private Long id;
    @NonNull
    private String name;
    private double lat;
    private double lng;
}
