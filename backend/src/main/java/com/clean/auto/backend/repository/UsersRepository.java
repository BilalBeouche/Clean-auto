package com.clean.auto.backend.repository;
import com.clean.auto.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    // Additional query methods can be defined here if needed

    
}