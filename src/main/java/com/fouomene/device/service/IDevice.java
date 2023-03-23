package com.fouomene.device.service;

import com.fouomene.device.exception.OneLogicBusinessException;
import com.fouomene.device.model.dto.DeviceDto;
import com.fouomene.device.model.entities.StatusDeviceType;

import java.util.List;

public interface IDevice {

    DeviceDto createDevice(DeviceDto deviceDto) throws OneLogicBusinessException;

    DeviceDto findDeviceById(Long id) throws OneLogicBusinessException;

    int deleteDeviceByCode(String code) throws OneLogicBusinessException;

    DeviceDto updateDevice(DeviceDto deviceDto) throws OneLogicBusinessException;

    List<DeviceDto> getAllDevices();

    StatusDeviceType getStatusDeviceByCode(String code) throws OneLogicBusinessException;

}
