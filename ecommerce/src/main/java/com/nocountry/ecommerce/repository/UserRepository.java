package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.dto.AuthenticationRequest;
import com.nocountry.ecommerce.dto.AuthenticationResponse;
import com.nocountry.ecommerce.dto.UserDto;
import com.nocountry.ecommerce.entities.User;

import java.util.Optional;

public interface UserRepository {


    AuthenticationResponse register(UserDto userDto);


    Optional<UserDto> findByEmail(String email);

    AuthenticationResponse authentication(AuthenticationRequest request);

}
