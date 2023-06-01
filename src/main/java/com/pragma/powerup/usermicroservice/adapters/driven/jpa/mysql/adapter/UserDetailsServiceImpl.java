package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.*;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IOwnerRepository ownerRepository;

    @Override
    public UserDetails loadUserByUsername(String dniNumber) throws UsernameNotFoundException {
        OwnerEntity usuario = ownerRepository.findByDniNumber(dniNumber).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(usuario.getRoleEntity());
        return PrincipalUser.build(usuario, roles);
    }
}
