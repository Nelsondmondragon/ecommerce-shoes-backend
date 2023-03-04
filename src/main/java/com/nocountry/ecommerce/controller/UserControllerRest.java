package com.nocountry.ecommerce.controller;

import com.nocountry.ecommerce.dto.UserDto;
import com.nocountry.ecommerce.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllerRest {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<Optional<UserDto>> findByEmail(HttpServletRequest request) {
        System.out.println("ooooo");
        return new ResponseEntity<>(this.userService.findByEmail(request), HttpStatus.OK);
    }

}
