package com.fitness.exceptions;

public class InvalidGoalException extends Throwable {

    public InvalidGoalException(String message) {
        super(message);
    }

    public InvalidGoalException(String message, Throwable cause) {
        super(message, cause);
    }
}
