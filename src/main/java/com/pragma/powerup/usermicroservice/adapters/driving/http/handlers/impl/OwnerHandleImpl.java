package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.CustomerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OwnerDniRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OwnerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.OwnerResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IOwnerHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IOwnerRequestMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IOwnerResponseMapper;
import com.pragma.powerup.usermicroservice.domain.api.IOwnerServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerHandleImpl implements IOwnerHandler {

    private final IOwnerServicePort ownerServicePort;
    private final IOwnerRequestMapper ownerRequestMapper;
    private final IOwnerResponseMapper ownerResponseMapper;

    @Override
    public void saveOwner(OwnerRequestDto ownerRequestDto) {
        ownerServicePort.saveOwner(ownerRequestMapper.toOwner(ownerRequestDto));
    }

    @Override
    public OwnerResponseDto getOwner(Long id) {
        return ownerResponseMapper.toOwnerResponseDto(ownerServicePort.getOwner(id));
    }

    @Override
    public OwnerResponseDto getOwnerByDni(OwnerDniRequestDto ownerDniRequestDto) {
        return ownerResponseMapper.toOwnerResponseDto(ownerServicePort.getOwnerByDni(ownerDniRequestDto.getDniNumber()));
    }


    @Override
    public void saveEmployee(EmployeeRequestDto employeeRequestDto) {
        ownerServicePort.saveEmployee(ownerRequestMapper.toOwnerEmployee(employeeRequestDto));
    }

    @Override
    public void saveCustomer(CustomerRequestDto customerRequestDto) {
        ownerServicePort.saveCustomer(ownerRequestMapper.toOwnerCustomer(customerRequestDto));
    }

}
