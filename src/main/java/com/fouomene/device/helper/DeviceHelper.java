package com.fouomene.device.helper;

import com.fouomene.device.repository.DeviceRepository;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
@AllArgsConstructor
public class DeviceHelper {
    private static String OLDEVICE = "OLDEVICE";

    private final DeviceRepository deviceRepository;

    public String getLastCodeDevice() {
        final String prefix = OLDEVICE;
        final String code = ""+new Random().nextInt(1000);
        if (code == null) {
            return prefix + "001";
        }
        return prefix + code;
    }

}
