package com.nocountry.ecommerce.controller;

import com.nocountry.ecommerce.dto.AuthenticationRequest;
import com.nocountry.ecommerce.dto.AuthenticationResponse;
import com.nocountry.ecommerce.dto.UserDto;
import com.nocountry.ecommerce.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthControllerRest {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registrationUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.registration(userDto), HttpStatus.CREATED);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest authenticationRequest) {
        return new ResponseEntity<>(userService.authentication(authenticationRequest), HttpStatus.OK);
    }



}
