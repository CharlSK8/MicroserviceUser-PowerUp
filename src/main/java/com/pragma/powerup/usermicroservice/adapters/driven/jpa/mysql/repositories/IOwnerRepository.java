package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOwnerRepository extends JpaRepository<OwnerEntity, Long> {

    Optional<OwnerEntity> findByDniNumber(Long dniNumber);


}
