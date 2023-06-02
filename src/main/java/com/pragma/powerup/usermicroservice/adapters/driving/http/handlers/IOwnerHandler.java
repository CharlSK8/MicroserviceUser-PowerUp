package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.CustomerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OwnerDniRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OwnerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;

public interface IOwnerHandler {

    void saveOwner(OwnerRequestDto ownerRequestDto);
    OwnerResponseDto getOwner(Long id);
    OwnerResponseDto getOwnerByDni(OwnerDniRequestDto ownerDniRequestDto);
    void saveEmployee(EmployeeRequestDto employeeRequestDto);
    void saveCustomer(CustomerRequestDto customerRequestDto);
}
