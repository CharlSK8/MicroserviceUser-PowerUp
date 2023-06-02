package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.CustomerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IOwnerHandler;
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
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerRestController {

    private final IOwnerHandler ownerHandler;

    @Operation(summary = "Add a new customer",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Customer created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Customer already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> saveEmployee(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        ownerHandler.saveCustomer(customerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.CUSTOMER_CREATED_MESSAGE));
    }
}
