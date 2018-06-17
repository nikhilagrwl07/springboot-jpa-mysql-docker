package com.fitness.exceptions;

public class UserSaveFailedException extends Exception {

    public UserSaveFailedException(String message) {
        super(message);
    }

    public UserSaveFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
