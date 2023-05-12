package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OwnerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.PersonRequestDto;

public interface IOwnerHandler {

    void saveOwner(OwnerRequestDto ownerRequestDto);
}
