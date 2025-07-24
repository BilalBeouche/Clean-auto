package com.clean.auto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Additional query methods can be defined here if needed

}
