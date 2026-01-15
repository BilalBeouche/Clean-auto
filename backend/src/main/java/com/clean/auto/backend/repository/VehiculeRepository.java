package com.clean.auto.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.entity.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByUser(Users user);

}
