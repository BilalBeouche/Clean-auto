package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.DTO.ReservationRequestDTO;
import com.clean.auto.backend.entity.Reservation;
import com.clean.auto.backend.entity.Users;

@Service
public interface ReservationService {

    List<Reservation> getAllReservation();

    List<Reservation> getAllReservationByUser(Users user);

    Reservation createReservation(ReservationRequestDTO reservation);

    Reservation updateReservation(Long id, Reservation reservation);

    void deleteReservation(Long id);

}
