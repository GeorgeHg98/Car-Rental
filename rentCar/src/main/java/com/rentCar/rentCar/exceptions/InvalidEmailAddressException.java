package com.rentCar.rentCar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "Invalid email address")

public class InvalidEmailAddressException extends RuntimeException {
    public InvalidEmailAddressException(String email) {
        super(String.format("Email address %s is not valid.", email));
    }
}
