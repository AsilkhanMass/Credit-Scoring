package com.example.creditscoring.dto.user;

import java.math.BigDecimal;

public record RegisterDto(
        String name,
        String lastName,
        String email,
        String password,
        double salary
) {
}
