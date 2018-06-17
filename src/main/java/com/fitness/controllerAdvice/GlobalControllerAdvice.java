package com.fitness.controllerAdvice;

import com.fitness.exceptions.ErrorResponse;
import com.fitness.exceptions.InvalidGoalException;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.exceptions.UserSaveFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler({InvalidGoalException.class,UserNotFoundException.class})
    public ResponseEntity<ErrorResponse> invalidGoalExceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(UserSaveFailedException.class)
    public ResponseEntity<ErrorResponse> usersaveFailedExceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(ex.getMessage());
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<ErrorResponse> UserNotFoundExceptionHandler(Exception ex) {
//        ErrorResponse error = new ErrorResponse();
//        error.setErrorCode(HttpStatus.NOT_FOUND.value());
//        error.setMessage(ex.getMessage());
//        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
//    }
}
