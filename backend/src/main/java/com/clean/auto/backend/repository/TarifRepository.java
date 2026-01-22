package com.clean.auto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Tarif;

public interface TarifRepository extends JpaRepository<Tarif, Long> {
    Tarif getTarifByPrestationId(Long prestationId);
}

// Additional query methods can be defined here if needed
