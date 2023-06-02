package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerRequestDto {
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    private String name;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    private String surname;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    @Pattern(regexp="[0-9]*", message = Constants.DNI_ERROR)
    private String dniNumber;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    @Pattern(regexp = "^[+]?[0-9]+$", message = Constants.PHONE_VALIDATION)
    @Size(min = 10, max = 13, message = Constants.PHONE_LENGTH)
    private String phone;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    @Email(message = Constants.EMAIL_VALIDATION)
    private String mail;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    private String password;
}
