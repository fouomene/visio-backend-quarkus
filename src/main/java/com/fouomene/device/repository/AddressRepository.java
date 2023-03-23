package com.fouomene.device.repository;

import com.fouomene.device.model.entities.AddressEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressRepository implements PanacheRepositoryBase<AddressEntity, Long> {

}