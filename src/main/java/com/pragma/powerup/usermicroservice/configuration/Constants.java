package com.pragma.powerup.usermicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final Long CLIENT_ROLE_ID = 1L;
    public static final Long EMPLOYEE_ROLE_ID = 2L;
    public static final Long PROVIDER_ROLE_ID = 3L;
    public static final Long OWNER_ROLE_ID = 3L;
    public static final int MAX_PAGE_SIZE = 2;
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String PERSON_CREATED_MESSAGE = "Person created successfully";
    public static final String USER_CREATED_MESSAGE = "User created successfully";
    public static final String OWNER_CREATED_MESSAGE = "Owner created successfully";
    public static final String USER_DELETED_MESSAGE = "User deleted successfully";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error: ";
    public static final String RESPONSE_WARNING_MESSAGE_KEY = "warning: ";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String PERSON_ALREADY_EXISTS_MESSAGE = "A person already exists with the DNI number provided";
    public static final String OWNER_ALREADY_EXISTS_MESSAGE = "A owner already exists with the DNI number provided";
    public static final String MAIL_ALREADY_EXISTS_MESSAGE = "A person with that mail already exists";
    public static final String PERSON_NOT_FOUND_MESSAGE = "No person found with the id provided";
    public static final String ROLE_NOT_FOUND_MESSAGE = "No role found with the id provided";
    public static final String ROLE_NOT_ALLOWED_MESSAGE = "No permission granted to create users with this role";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "A user already exists with the role provided";
    public static final String USER_NOT_FOUND_MESSAGE = "No user found with the role provided";
    public static final String OWNER_MINOR_MESSAGE = "The person admitted is a minor";
    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
    public static final String DATA_NULL_OR_EMPTY = "The data entered cannot be empty or null";
    public static final String PHONE_LENGTH = "The phone must be min 10 and max 13";
    public static final String ENTERED_NULL_OR_EMPTY = "The entered field cannot be empty or null";
    public static final String EMAIL_VALIDATION = "Must be a properly formatted email address";
    public static final String DNI_ERROR = "The field must be numeric only";
    public static final String PHONE_VALIDATION = "The field must contain numbers or the symbol '+'";
    public static final String EMAIL_NOT_FOUND_MESSAGE = "Email not found in the database";
    public static final String PASSWORD_NOT_FOUND_MESSAGE = "Password not found in the database";
    public static final String ROLE_INVALID_MESSAGE = "Access denied, invalid role for this endpoint";
}
