package com.nocountry.ecommerce.dto;

import lombok.*;

@Data
@Builder
//@RequiredArgsConstructor
public class AuthenticationResponse {
    private String token;
}
