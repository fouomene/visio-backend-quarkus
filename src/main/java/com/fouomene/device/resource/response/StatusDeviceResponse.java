package com.fouomene.device.resource.response;

import com.fouomene.device.model.entities.StatusDeviceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusDeviceResponse {
    private StatusDeviceType status;
}
