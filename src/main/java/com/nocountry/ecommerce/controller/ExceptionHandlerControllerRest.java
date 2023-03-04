package com.nocountry.ecommerce.controller;

import com.nocountry.ecommerce.dto.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerControllerRest {

    @ExceptionHandler(value = {AuthenticationException.class})
    public ResponseEntity<Object> handleApiRequestCredentialException(HttpServletRequest request, AuthenticationException apiRequestException) {
        HttpStatus unauthorized = HttpStatus.UNAUTHORIZED;
        ExceptionDto exceptionDto = new ExceptionDto(apiRequestException.getMessage(),
                unauthorized,
                unauthorized.value(),
                request.getRequestURL().toString(),
                new Date());
        return new ResponseEntity<>(exceptionDto, unauthorized);
    }
}
