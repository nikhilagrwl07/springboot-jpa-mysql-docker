package com.fitness.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidGoalException extends RuntimeException {

    public InvalidGoalException(String message) {
        super(message);
    }

    public InvalidGoalException(String message, Throwable cause) {
        super(message, cause);
    }
}
