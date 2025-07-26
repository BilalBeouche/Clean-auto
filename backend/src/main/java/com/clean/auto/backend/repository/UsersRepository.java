package com.clean.auto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    // Additional query methods can be defined here if needed
    Users findByEmail(String email);

}