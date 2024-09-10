package com.example.creditscoring.dto.user;

public record UserDto(
        String name,
        String lastName,
        String password,
        String email,
        double salary,
        String role
) {
}
