package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IOwnerServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.MinorException;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import com.pragma.powerup.usermicroservice.domain.spi.IOwnerPersistencePort;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.Period;


public class OwnerUseCase implements IOwnerServicePort {

    @Value("${minimumAge}")
    private int minimumAge;

    private final IOwnerPersistencePort ownerPersistencePort;

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
}
