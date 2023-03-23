package com.fouomene.device.repository;

import com.fouomene.device.model.entities.DeviceEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeviceRepository implements PanacheRepositoryBase<DeviceEntity, Long> {

}