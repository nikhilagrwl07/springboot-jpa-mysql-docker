package com.fitness.common;

public enum ResponseEnum {
    GOAL_NOT_FOUND("Goal not found"),
    INVALID_REQUEST_BODY("Invalid request body"),
    USER_NOT_FOUND("User not found");
    String message;

    ResponseEnum(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
