package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Reservation;
import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservationByUser(Users user) {
        return reservationRepository.findByUser(user);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {

        Reservation existingUser = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé" + id));

        existingUser.setDateReservation(reservation.getDateReservation());
        existingUser.setPrixFinal(reservation.getPrixFinal());

        return reservationRepository.save(existingUser);
    }

    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur introuvable");
        } else {
            reservationRepository.deleteById(id);
            System.out.println("utilisateur supprimé");
        }
    }
}
