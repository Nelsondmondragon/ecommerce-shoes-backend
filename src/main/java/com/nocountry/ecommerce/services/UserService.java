package com.nocountry.ecommerce.services;

import com.nocountry.ecommerce.dto.AuthenticationRequest;
import com.nocountry.ecommerce.dto.AuthenticationResponse;
import com.nocountry.ecommerce.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;


public interface UserService {

    AuthenticationResponse registration(UserDto userDto);

    Optional<UserDto> findByEmail(String email);

    Optional<UserDto> findByEmail(HttpServletRequest request);


    AuthenticationResponse authentication(AuthenticationRequest authenticationRequest);
}
