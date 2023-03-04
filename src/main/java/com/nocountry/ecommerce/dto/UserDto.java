package com.nocountry.ecommerce.dto;

import com.nocountry.ecommerce.entities.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
