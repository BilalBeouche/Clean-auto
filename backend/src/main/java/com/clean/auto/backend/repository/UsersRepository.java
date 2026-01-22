package com.clean.auto.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    // Additional query methods can be defined here if needed

    Optional<Users> findByEmail(String email);

    Users save(Users user);

    Optional<Users> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);

}