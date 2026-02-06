package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.DTO.ReservationRequestDTO;
import com.clean.auto.backend.entity.Reservation;

@Service
public interface ReservationService {

    List<Reservation> getAllReservation();

    List<Reservation> getAllReservationByUser();

    Reservation createReservation(ReservationRequestDTO reservation);

    Reservation updateReservation(Long id, Reservation reservation);

    void deleteReservation(Long id);

}
