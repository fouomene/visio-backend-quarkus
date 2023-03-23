package com.fouomene.device.repository;

import com.fouomene.device.model.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Integer> {

}
