package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginSquareRequestDto {

    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    private String mail;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    private String password;
}
