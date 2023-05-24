package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.OwnerAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IOwnerEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IOwnerRepository;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import com.pragma.powerup.usermicroservice.domain.spi.IOwnerPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor
public class OwnerMysqlAdapter implements IOwnerPersistencePort {

    private final IOwnerRepository ownerRepository;
    private final IOwnerEntityMapper ownerEntityMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void saveOwner(Owner owner) {
        if(ownerRepository.findByDniNumber(owner.getDniNumber()).isPresent()){
            throw new OwnerAlreadyExistsException();
        }
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        ownerRepository.save(ownerEntityMapper.toEntity(owner));
    }

    @Override
    public Owner getOwner(Long id) {
        Optional<OwnerEntity> ownerEntity = ownerRepository.findById(id);
        return ownerEntityMapper.toOwner(ownerEntity.get());
    }
}
