package com.clean.auto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Avis;

public interface AvisRepository extends JpaRepository<Avis, Long> {
    // Additional query methods can be defined here if needed

}
