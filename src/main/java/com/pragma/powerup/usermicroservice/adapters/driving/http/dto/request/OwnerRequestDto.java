package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;


import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
public class OwnerRequestDto {

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
    @NotNull
    private LocalDate birthOfDate;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    @Email(message = Constants.EMAIL_VALIDATION)
    private String mail;
    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    private String password;
    @NotNull(message =  Constants.ENTERED_NULL_OR_EMPTY)
    @Min(value = 1L, message = "min 1 max 3")
    private Long idRole;

}
