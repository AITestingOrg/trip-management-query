package org.aitesting.microservices.tripmanagement.query.service.controllers;

import org.aitesting.microservices.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TripControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(NotFoundException.class)
    public void handleNotFound() {
    }
}
