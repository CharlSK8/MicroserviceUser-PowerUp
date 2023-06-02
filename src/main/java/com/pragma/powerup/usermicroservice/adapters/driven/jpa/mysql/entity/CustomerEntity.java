package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerEntity extends OwnerEntity{

    public CustomerEntity(){
        super();
        super.setRoleEntity(new RoleEntity(5L,"ROLE_CUSTOMER","ROLE_CUSTOMER"));
    }
}
