package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmployeeEntity extends OwnerEntity {
    public EmployeeEntity() {
        super();
        super.setRoleEntity(new RoleEntity(4L,"ROLE_EMPLOYEE","ROLE_EMPLOYEE"));
    }
}
