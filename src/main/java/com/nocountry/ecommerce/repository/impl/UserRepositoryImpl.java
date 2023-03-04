package com.nocountry.ecommerce.repository.impl;

import com.nocountry.ecommerce.config.JwtService;
import com.nocountry.ecommerce.dto.AuthenticationRequest;
import com.nocountry.ecommerce.dto.AuthenticationResponse;
import com.nocountry.ecommerce.dto.UserDto;
import com.nocountry.ecommerce.entities.User;
import com.nocountry.ecommerce.exception.EmailNotExistsException;
import com.nocountry.ecommerce.repository.UserRepository;
import com.nocountry.ecommerce.repository.jpa.UserRepositoryJpa;
import com.nocountry.ecommerce.repository.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    private final UserMapper userMapper;

    private final JwtService jwtService;

//
//    @Override
//    public AuthenticationResponse register(UserDto userDto) {
//        var user = userMapper.toUser(userDto);
//        userRepositoryJpa.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepositoryJpa.existsByEmail(email);
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return userRepositoryJpa.findByEmail(email).map(userMapper::toUserDto);
    }

    @Override
    public UserDto save(UserDto userDto) {
        return this.userMapper.toUserDto(this.userRepositoryJpa.save(this.userMapper.toUser(userDto)));
    }

//    @Override
//    public AuthenticationResponse authentication(AuthenticationRequest request) {
//
//
//        var user = userRepositoryJpa.findByEmail(request.getEmail()).orElseThrow(() -> new EmailNotExistsException("Email not exist"));
//        String jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//
//    }
}
