package com.fouomene.device.model.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "device_entity")
public class DeviceEntity extends AbstractEntity {

    @Column(nullable = false)
    private String code;
    private String name;
    private String ip;
    @Enumerated(EnumType.STRING)
    private StatusDeviceType status;
    @OneToOne(cascade=CascadeType.ALL)
    private AddressEntity addressEntity;


    public static Optional<DeviceEntity> findByCode(String code){
        return find("code", code).firstResultOptional();
    }

}