package com.rentCar.rentCar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "Email address already in use")
public class EmailAddressAlreadyUsedException extends RuntimeException {
    public EmailAddressAlreadyUsedException(String email) {
        super(String.format("A user with email address %s is already registered.", email));
    }
}
