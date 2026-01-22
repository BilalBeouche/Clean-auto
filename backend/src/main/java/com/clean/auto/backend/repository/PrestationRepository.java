package com.clean.auto.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Avis;
import com.clean.auto.backend.entity.Prestation;

public interface PrestationRepository extends JpaRepository<Prestation, Long> {

    Prestation save(Prestation prestation);

    Avis deleteById(long id);

    Optional<Prestation> findById(Long id);

    // Additional query methods can be defined here if needed

}
