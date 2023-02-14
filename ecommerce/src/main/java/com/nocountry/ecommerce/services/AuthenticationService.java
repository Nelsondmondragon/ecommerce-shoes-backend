package com.nocountry.ecommerce.services;

import com.nocountry.ecommerce.dto.AuthenticationRequest;
import com.nocountry.ecommerce.dto.AuthenticationResponse;
import com.nocountry.ecommerce.dto.UserDto;


public interface AuthenticationService {

    AuthenticationResponse registration(UserDto userDto);


    AuthenticationResponse authentication(AuthenticationRequest authenticationRequest);
}
