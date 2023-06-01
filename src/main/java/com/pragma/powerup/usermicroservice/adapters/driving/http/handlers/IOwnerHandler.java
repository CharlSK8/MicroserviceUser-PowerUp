package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OwnerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;

public interface IOwnerHandler {

    void saveOwner(OwnerRequestDto ownerRequestDto);
    OwnerResponseDto getOwner(Long id);
    void saveEmployee(EmployeeRequestDto employeeRequestDto);
}
