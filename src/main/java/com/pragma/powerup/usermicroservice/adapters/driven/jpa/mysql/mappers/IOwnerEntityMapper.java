package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.EmployeeEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OwnerEntity;
import com.pragma.powerup.usermicroservice.domain.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOwnerEntityMapper {
    @Mapping(target = "roleEntity.id", source = "role.id")
    OwnerEntity toEntity(Owner owner);
    @Mapping(target = "role.id", source = "roleEntity.id")
    Owner toOwner(OwnerEntity ownerEntity);
    EmployeeEntity toEntityEmployee(Owner owner);
}
