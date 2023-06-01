package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.PersonEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IOwnerRepository extends JpaRepository<OwnerEntity, Long> {

    Optional<OwnerEntity> findByDniNumber(String dniNumber);
    Optional<OwnerEntity> findByMail(String mail);
    List<UserEntity> findAllByRoleEntityId(Long idRole, Pageable pageable);


}
