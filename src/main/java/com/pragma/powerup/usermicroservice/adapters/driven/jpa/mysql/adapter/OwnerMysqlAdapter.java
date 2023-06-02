package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.DniAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MailAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.OwnerAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.OwnerNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IOwnerEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IOwnerRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeeRequestDto;
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
        if(ownerRepository.findByDniNumber(owner.getDniNumber().toString()).isPresent()){
            throw new OwnerAlreadyExistsException();
        }
        if(ownerRepository.findByMail(owner.getMail()).isPresent()){
            throw new MailAlreadyExistsException();
        }
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        ownerRepository.save(ownerEntityMapper.toEntity(owner));
    }

    @Override
    public void saveEmployee(Owner owner) {
        if(ownerRepository.findByDniNumber(owner.getDniNumber().toString()).isPresent()){
            throw new DniAlreadyExistsException();
        }
        if(ownerRepository.findByMail(owner.getMail()).isPresent()){
            throw new MailAlreadyExistsException();
        }
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        ownerRepository.save(ownerEntityMapper.toEntityEmployee(owner));
    }

    @Override
    public void saveCustomer(Owner owner) {
        if(ownerRepository.findByDniNumber(owner.getDniNumber().toString()).isPresent()){
            throw new DniAlreadyExistsException();
        }
        if(ownerRepository.findByMail(owner.getMail()).isPresent()){
            throw new MailAlreadyExistsException();
        }
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        ownerRepository.save(ownerEntityMapper.toEntityCustomer(owner));
    }

    @Override
    public Owner getOwner(Long id) {
        Optional<OwnerEntity> ownerEntity = ownerRepository.findById(id);
        if (!ownerEntity.isPresent()) {
            throw new OwnerNotFoundException();
        }
        return ownerEntityMapper.toOwner(ownerEntity.get());
    }
    @Override
    public Owner getOwnerByDni(String dniNumber) {
        Optional<OwnerEntity> ownerEntity = ownerRepository.findByDniNumber(dniNumber);
        if (!ownerEntity.isPresent()) {
            throw new OwnerNotFoundException();
        }
        return ownerEntityMapper.toOwner(ownerEntity.get()) ;
    }

    @Override
    public Optional<OwnerEntity> findByMail(String mail) {
        return ownerRepository.findByMail(mail);
    }
}
