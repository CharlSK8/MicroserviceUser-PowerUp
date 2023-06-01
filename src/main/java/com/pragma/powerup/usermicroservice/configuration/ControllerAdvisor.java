package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.InvalidRoleException;
import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.MailNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.PasswordNotFoundException;
import com.pragma.powerup.usermicroservice.domain.exceptions.MinorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.configuration.Constants.*;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(AuthenticationException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, WRONG_CREDENTIALS_MESSAGE));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_DATA_FOUND_MESSAGE));
    }
    @ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handlePersonAlreadyExistsException(
            PersonAlreadyExistsException personAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PERSON_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(MailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleMailAlreadyExistsException(
            MailAlreadyExistsException mailAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, MAIL_ALREADY_EXISTS_MESSAGE));
    }
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePersonNotFoundException(
            PersonNotFoundException personNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PERSON_NOT_FOUND_MESSAGE));
    }
    @ExceptionHandler(RoleNotAllowedForCreationException.class)
    public ResponseEntity<Map<String, String>> handleRoleNotAllowedForCreationException(
            RoleNotAllowedForCreationException roleNotAllowedForCreationException) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, ROLE_NOT_ALLOWED_MESSAGE));
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExistsException(
            UserAlreadyExistsException userAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, USER_ALREADY_EXISTS_MESSAGE));
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(
            UserNotFoundException userNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, USER_NOT_FOUND_MESSAGE));
    }
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRoleNotFoundException(
            RoleNotFoundException roleNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, ROLE_NOT_FOUND_MESSAGE));
    }

    @ExceptionHandler(OwnerAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleOwnerAlreadyExistsException(
            OwnerAlreadyExistsException ownerAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, OWNER_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(MinorException.class)
    public ResponseEntity<Map<String, String>> handleMinorException(
            MinorException minorException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, OWNER_MINOR_MESSAGE));
    }
    @ExceptionHandler(MailNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMailNotFoundException(
            MailNotFoundException mailNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, EMAIL_NOT_FOUND_MESSAGE));
    }

    @ExceptionHandler(PasswordNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePasswordNotFoundException(
            PasswordNotFoundException passwordNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PASSWORD_NOT_FOUND_MESSAGE));
    }
    @ExceptionHandler(InvalidRoleException.class)
    public ResponseEntity<Map<String, String>> handleInvalidRoleException(
            InvalidRoleException invalidRoleException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_WARNING_MESSAGE_KEY, ROLE_INVALID_MESSAGE));
    }



}
