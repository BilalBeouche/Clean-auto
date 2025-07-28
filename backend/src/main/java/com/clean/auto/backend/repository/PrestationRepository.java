package com.clean.auto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Prestation;

public interface PrestationRepository extends JpaRepository<Prestation, Long> {
    // Additional query methods can be defined here if needed

}
