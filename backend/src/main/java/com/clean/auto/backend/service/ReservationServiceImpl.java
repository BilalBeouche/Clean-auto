package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clean.auto.backend.DTO.ReservationRequestDTO;
import com.clean.auto.backend.entity.Prestation;
import com.clean.auto.backend.entity.Reservation;
import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.entity.Vehicule;
import com.clean.auto.backend.repository.PrestationRepository;
import com.clean.auto.backend.repository.ReservationRepository;
import com.clean.auto.backend.repository.VehiculeRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    PrestationRepository prestationRepository;
    VehiculeRepository vehiculeRepository;

    private final UserService userService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserService userService,
            PrestationRepository prestationRepository, VehiculeRepository vehiculeRepository) {
        this.reservationRepository = reservationRepository;
        this.prestationRepository = prestationRepository;
        this.vehiculeRepository = vehiculeRepository;

        this.userService = userService;
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation createReservation(ReservationRequestDTO dto) {

        Users user = userService.getCurrentUsers();

        if (dto.getIdPrestation() == null) {
            throw new IllegalArgumentException("La prestation est obligatoire");
        }

        if (dto.getIdVehicule() == null) {
            throw new IllegalArgumentException("Le véhicule est obligatoire");
        }

        Prestation prestation = prestationRepository
                .findById(dto.getIdPrestation())
                .orElseThrow(() -> new RuntimeException("Prestation introuvable"));

        Vehicule vehicule = vehiculeRepository
                .findById(dto.getIdVehicule())
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setPrestation(prestation);
        reservation.setVehicule(vehicule);
        reservation.setDateReservation(java.sql.Date.valueOf(dto.getDateReservation()));
        reservation.setPrixFinal(dto.getPrixFinal());

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
