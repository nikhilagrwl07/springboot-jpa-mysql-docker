package com.fitness.controllerAdvice;

import com.fitness.exceptions.ExceptionResponse;
import com.fitness.exceptions.InvalidGoalException;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.exceptions.UserSaveFailedException;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@Log4j
@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidGoalException.class, UserNotFoundException.class})
    public ResponseEntity<ExceptionResponse> invalidGoalExceptionHandler(
            WebRequest httpRequestHandler, Exception ex) {

        ExceptionResponse error = new ExceptionResponse(ex.getMessage(),
                UUID.randomUUID(), ((ServletWebRequest) httpRequestHandler).getRequest().getRequestURI());

        log.error("Error Occurred :: {} ", ex.getCause());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(value = UserSaveFailedException.class)
    public ResponseEntity<ExceptionResponse> userSaveFailedExceptionHandler(
            WebRequest httpRequestHandler, Exception ex) {

        ExceptionResponse error = new ExceptionResponse(ex.getMessage(),
                UUID.randomUUID(), ((ServletWebRequest) httpRequestHandler).getRequest().getRequestURI());

        log.error("Error Occurred :: {} ", ex.getCause());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
