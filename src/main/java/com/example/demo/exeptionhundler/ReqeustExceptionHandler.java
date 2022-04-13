package com.example.demo.exeptionhundler;


import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ReqeustExceptionHandler {

    ExceptionModel exceptionModel;

    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> exceptionHundler(@NotNull RequestException e) {

        HttpStatus badStatus = HttpStatus.BAD_REQUEST;
        exceptionModel = new ExceptionModel(
                e.getMessage(),
                badStatus,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(exceptionModel, badStatus);
    }
}
