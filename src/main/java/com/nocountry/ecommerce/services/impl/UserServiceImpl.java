package com.nocountry.ecommerce.services.impl;

import com.nocountry.ecommerce.config.JwtService;
import com.nocountry.ecommerce.dto.AuthenticationRequest;
import com.nocountry.ecommerce.dto.AuthenticationResponse;
import com.nocountry.ecommerce.dto.UserDto;
import com.nocountry.ecommerce.entities.Role;
import com.nocountry.ecommerce.entities.User;
import com.nocountry.ecommerce.exception.EmailNotExistsException;
import com.nocountry.ecommerce.exception.PasswordInvalidException;
import com.nocountry.ecommerce.repository.UserRepository;
import com.nocountry.ecommerce.repository.jpa.UserRepositoryJpa;
import com.nocountry.ecommerce.repository.mapper.UserMapper;
import com.nocountry.ecommerce.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public AuthenticationResponse registration(UserDto userDto) {
        userDto.setRole(Role.USER);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        var user = userMapper.toUser(this.userRepository.save(userDto));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UserDto> findByEmail(HttpServletRequest request) {
        System.out.println(" llll");
        String authHeader = request.getHeader("Authorization");

        System.out.println(authHeader + " llll");
        return Optional.empty();
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {
        if (this.findByEmail(request.getEmail()).isEmpty()) {
            throw new EmailNotExistsException("Email no existe");
        }
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new PasswordInvalidException("Contraseña incorrecta");
        }
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new EmailNotExistsException("Email not exist"));
        String jwtToken = jwtService.generateToken(userMapper.toUser(user));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
