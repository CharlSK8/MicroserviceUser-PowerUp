package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Owner;

import java.util.Optional;

public interface IOwnerServicePort {

    void saveOwner(Owner owner);
    Owner getOwner(Long id);
    Optional<OwnerEntity> findByMail(String mail);
    boolean comparePasswords(CharSequence passwordDto, String passwordEntity);
}
