package com.fitness.exceptions;


import com.fitness.common.ResponseEnum;
public class ErrorResponse {

    private ResponseEnum code;
    private String message;

    public ErrorResponse(ResponseEnum code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEnum getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
