package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.domain.model.Owner;

import java.util.Optional;

public interface IOwnerPersistencePort {

    void saveOwner(Owner owner);

    Owner getOwner(Long id);
    Optional<OwnerEntity> findByMail(String mail);
}
