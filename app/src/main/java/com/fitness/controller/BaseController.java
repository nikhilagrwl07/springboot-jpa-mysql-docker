package com.fitness.controller;

import com.fitness.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import static com.fitness.common.ResponseEnum.INVALID_REQUEST_BODY;

public class BaseController {

    protected ResponseEntity<?> getErrorResponse(BindingResult bindingResult){
        ErrorResponse errorResponse = new ErrorResponse(INVALID_REQUEST_BODY, INVALID_REQUEST_BODY.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
