package com.fitness.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserSaveFailedException extends RuntimeException {

    public UserSaveFailedException(String message) {
        super(message);
    }

    public UserSaveFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
