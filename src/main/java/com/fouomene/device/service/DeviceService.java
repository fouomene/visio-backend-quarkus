package com.fouomene.device.service;


import com.fouomene.device.exception.ErrorInfo;
import com.fouomene.device.exception.OneLogicBusinessException;
import com.fouomene.device.helper.DeviceHelper;
import com.fouomene.device.model.dto.DeviceDto;
import com.fouomene.device.model.entities.AddressEntity;
import com.fouomene.device.model.entities.DeviceEntity;
import com.fouomene.device.model.entities.StatusDeviceType;
import com.fouomene.device.repository.AddressRepository;
import com.fouomene.device.repository.DeviceRepository;
import com.fouomene.device.service.mapper.AddressMapper;
import com.fouomene.device.service.mapper.DeviceMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class DeviceService implements IDevice {

    private  final DeviceMapper deviceMapper;
    private final DeviceRepository deviceRepository;
    private final AddressMapper addressMapper;

    private final AddressRepository addressRepository;

    private final DeviceHelper deviceHelper;
    @Override
    @Transactional
    public DeviceDto createDevice(DeviceDto deviceDto) throws OneLogicBusinessException {
        checkIp(deviceDto.getIp());
        checkIpAlreadyUsed(deviceDto.getIp());
        checkName(deviceDto.getName());
        checkNameAlreadyUsed(deviceDto.getName());
        checkNameAddressAlreadyUsed(deviceDto.getAddress().getName());

        deviceDto.setCode(deviceHelper.getLastCodeDevice());
        deviceRepository.persist(deviceMapper.toEntity(deviceDto));
        return deviceDto;
    }

    @Override
    public DeviceDto findDeviceById(Long id) throws OneLogicBusinessException {
        return deviceMapper.toDto(deviceRepository.findByIdOptional(id)
                .orElseThrow(() -> new OneLogicBusinessException(ErrorInfo.DEVICE_NOT_FOUND)));
    }

    @Override
    public int deleteDeviceByCode(String code) throws OneLogicBusinessException {
        checkCode(code);
        DeviceEntity deviceEntity = DeviceEntity.findByCode(code).
                orElseThrow(() -> new OneLogicBusinessException(ErrorInfo.DEVICE_NOT_FOUND));
        deviceRepository.deleteById(deviceEntity.getId());
        return 1;
    }
    @Override
    @Transactional
    public DeviceDto updateDevice(DeviceDto deviceDto) throws OneLogicBusinessException {
        DeviceEntity deviceEntity = deviceRepository.findByIdOptional(deviceDto.getId())
                .orElseThrow(() -> new OneLogicBusinessException(ErrorInfo.DEVICE_NOT_FOUND));
        deviceMapper.copy(deviceDto, deviceEntity);
        deviceRepository.persistAndFlush(deviceEntity);
        return deviceMapper.toDto(deviceEntity);
    }

    @Override
    public List<DeviceDto> getAllDevices() {
        return deviceRepository.findAll()
                .stream()
                .map(deviceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StatusDeviceType getStatusDeviceByCode(String code) throws OneLogicBusinessException {
        checkCode(code);
        DeviceEntity deviceEntity = DeviceEntity.findByCode(code)
                .orElseThrow(() -> new OneLogicBusinessException(ErrorInfo.DEVICE_NOT_FOUND));
        return deviceEntity.getStatus();
    }

    private void checkCode(String code) throws OneLogicBusinessException {
        if (Objects.isNull(code)) {
            throw new OneLogicBusinessException(ErrorInfo.CODE_DEVICE_REQUIRED);
        }
    }

    private void checkIp(String ip) throws OneLogicBusinessException {
        if (Objects.isNull(ip)) {
            throw new OneLogicBusinessException(ErrorInfo.IP_DEVICE_REQUIRED);
        }
    }

    private void checkIpAlreadyUsed(String ip) throws OneLogicBusinessException {
        /*if (deviceRepository.existsByIpIgnoreCase(ip)) {
            throw new OneLogicBusinessException(ErrorInfo.IP_DEVICE_ALREADY_USED);
        }*/
    }

    private void checkName(String name) throws OneLogicBusinessException {
        if (Objects.isNull(name)) {
            throw new OneLogicBusinessException(ErrorInfo.NAME_DEVICE_REQUIRED);
        }
    }

    private void checkNameAlreadyUsed(String name) throws OneLogicBusinessException {
       /* if (deviceRepository.existsByNameIgnoreCase(name)) {
            throw new OneLogicBusinessException(ErrorInfo.NAME_DEVICE_ALREADY_USED);
        }*/
    }

    private void checkNameAddressAlreadyUsed(String name) throws OneLogicBusinessException {
       /* if (addressRepository.existsByNameIgnoreCase(name)) {
            throw new OneLogicBusinessException(ErrorInfo.NAME_ADDRESS_DEVICE_ALREADY_USED);
        }*/
    }

    @Transactional
    public List<DeviceDto> initDb() {

        AddressEntity addressEntity1 = AddressEntity.builder()
                .name("19 Rue Jeanne Braconnier")
                .lat(48.788768568373804)
                .lng(2.210908513594745)
                .build();
        DeviceEntity deviceEntity1 = DeviceEntity.builder()
                .code(deviceHelper.getLastCodeDevice())
                .name("Imprimande HP 20")
                .ip("192.168.2.1")
                .status(StatusDeviceType.ONLINE)
                .addressEntity(addressEntity1)
                .build();

        deviceRepository.persist(deviceEntity1);

        AddressEntity addressEntity2 = AddressEntity.builder()
                .name("23 Rue OneLogic")
                .lat(48.7851776147739)
                .lng(2.2183757834688094)
                .build();
        DeviceEntity deviceEntity2 = DeviceEntity.builder()
                .code(deviceHelper.getLastCodeDevice())
                .name("Scanner HP 30")
                .ip("192.168.2.2")
                .status(StatusDeviceType.ONLINE)
                .addressEntity(addressEntity2)
                .build();

        deviceRepository.persist(deviceEntity2);

        AddressEntity addressEntity3 = AddressEntity.builder()
                .name("23 Rue Meudon")
                .lat(48.79363149743951)
                .lng(2.219834905168339)
                .build();
        DeviceEntity deviceEntity3 = DeviceEntity.builder()
                .code(deviceHelper.getLastCodeDevice())
                .name("Ecran LG 46")
                .ip("192.168.2.46")
                .status(StatusDeviceType.OFFLINE)
                .addressEntity(addressEntity3)
                .build();

        deviceRepository.persist(deviceEntity3);


         deviceRepository.findAll().stream().forEach(System.out::println);

     return deviceRepository.findAll()
                .stream()
                .map(deviceMapper::toDto)
                .collect(Collectors.toList());
    }


}
