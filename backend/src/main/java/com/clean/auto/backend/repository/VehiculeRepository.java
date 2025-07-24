package com.clean.auto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    // Additional query methods can be defined here if needed

}
