package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OwnerDniRequestDto {

    @NotBlank(message = Constants.ENTERED_NULL_OR_EMPTY)
    @Pattern(regexp="[0-9]*", message = Constants.DNI_ERROR)
    private String dniNumber;
}
