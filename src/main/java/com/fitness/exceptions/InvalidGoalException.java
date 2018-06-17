package com.fitness.exceptions;

public class InvalidGoalException extends Exception {

    public InvalidGoalException(String message) {
        super(message);
    }

    public InvalidGoalException(String message, Throwable cause) {
        super(message, cause);
    }
}
