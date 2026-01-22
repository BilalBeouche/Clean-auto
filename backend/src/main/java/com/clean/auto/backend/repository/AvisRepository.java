package com.clean.auto.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Avis;

public interface AvisRepository extends JpaRepository<Avis, Long> {

    Optional<Avis> findById(long id);

    boolean existsById(long id);

    // Additional query methods can be defined here if needed
    Avis deleteById(long id);

    Avis save(Avis avis);
}
