package com.clean.auto.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Reservation;
import com.clean.auto.backend.entity.Users;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Additional query methods can be defined here if needed

    List<Reservation> findByUser(Users user);

}
