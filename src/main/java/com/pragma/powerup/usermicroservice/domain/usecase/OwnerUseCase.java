package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeeRequestDto;
import com.pragma.powerup.usermicroservice.domain.api.IOwnerServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.MinorException;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import com.pragma.powerup.usermicroservice.domain.spi.IOwnerPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;


public class OwnerUseCase implements IOwnerServicePort {

    @Value("${minimumAge}")
    private int minimumAge;

    private final IOwnerPersistencePort ownerPersistencePort;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public OwnerUseCase(IOwnerPersistencePort ownerPersistencePort){
        this.ownerPersistencePort = ownerPersistencePort;
    }

    @Override
    public void saveOwner(Owner owner) {
            Period periodo = Period.between(owner.getBirthOfDate(), LocalDate.now());
            int age = periodo.getYears();
            if (age < minimumAge) {
                throw new MinorException();
            }
            ownerPersistencePort.saveOwner(owner);
        }

    @Override
    public void saveEmployee(Owner owner) {
        ownerPersistencePort.saveEmployee(owner);
    }

    @Override
    public void saveCustomer(Owner owner) {
        ownerPersistencePort.saveCustomer(owner);
    }

    @Override
    public Owner getOwner(Long id) {
        return ownerPersistencePort.getOwner(id);
    }

    @Override
    public Owner getOwnerByDni(String dniNumber) {
        return ownerPersistencePort.getOwnerByDni(dniNumber);
    }

    @Override
    public Optional<OwnerEntity> findByMail(String mail) {
        return ownerPersistencePort.findByMail(mail);
    }

    @Override
    public boolean comparePasswords(CharSequence passwordDto, String passwordEntity) {
        return passwordEncoder.matches(passwordDto, passwordEntity);
    }

}
