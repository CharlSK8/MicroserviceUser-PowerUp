package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IOwnerHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.utils.RequiresRole;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final IOwnerHandler ownerHandler;

    @Operation(summary = "Add a new employee",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Employee created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Employee already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/save")
    @RequiresRole("ROLE_OWNER")
    public ResponseEntity<Map<String, String>> saveEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        ownerHandler.saveEmployee(employeeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.EMPLOYEE_CREATED_MESSAGE));
    }
}
