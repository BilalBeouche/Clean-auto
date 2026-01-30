package com.clean.auto.backend.DTO;

public record UsersResponse(

        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber) {
}
