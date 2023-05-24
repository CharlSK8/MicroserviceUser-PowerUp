package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class OwnerResponseDto {

    private String name;
    private String surname;
    private String dniNumber;
    private String phone;
    private LocalDate birthOfDate;
    private String email;
    private String password;
    private Role role;

}
