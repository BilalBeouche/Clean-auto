package com.clean.auto.backend.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clean.auto.backend.DTO.ReservationRequestDTO;
import com.clean.auto.backend.entity.Prestation;
import com.clean.auto.backend.entity.Reservation;
import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.entity.Vehicule;
import com.clean.auto.backend.repository.PrestationRepository;
import com.clean.auto.backend.repository.ReservationRepository;
import com.clean.auto.backend.repository.UsersRepository;
import com.clean.auto.backend.repository.VehiculeRepository;
import com.clean.auto.backend.service.ReservationService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/reservation")
@RestController
public class ReservationController {

    @Autowired
    private final ReservationService reservationService;

    @Autowired
    private final VehiculeRepository vehiculeRepository;

    @Autowired
    private final PrestationRepository prestationRepository;
    @Autowired
    private final UsersRepository usersRepository;

    public ReservationController(ReservationRepository reservationRepository, ReservationService reservationService,
            UsersRepository usersRepository, VehiculeRepository vehiculeRepository,
            PrestationRepository prestationRepository) {

        this.reservationService = reservationService;
        this.usersRepository = usersRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.prestationRepository = prestationRepository;
    }

    @GetMapping("/allReservation")
    public List<Reservation> getAllReservations() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("utilisateur non trouvé"));

        return reservationService.getAllReservationByUser(user);
    }

    @PostMapping("/createReserve")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequestDTO request) {
        System.out.println("coucou");
        // Récupérer l'utilisateur connecté
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        // Récupérer le véhicule
        Vehicule vehicule = vehiculeRepository.findById(request.getIdVehicule())
                .orElseThrow(() -> new RuntimeException("Véhicule non trouvé"));

        // Récupérer la prestation
        Prestation prestation = prestationRepository.findById(request.getIdPrestation())
                .orElseThrow(() -> new RuntimeException("Prestation non trouvée"));

        // Construire la réservation
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setVehicule(vehicule);
        reservation.setPrestation(prestation);
        reservation.setPrixFinal(request.getPrixFinal());

        try {
            // Parser la date et ignorer l'heure (java.sql.Date ne stocke que la date sans
            // l'heure)
            LocalDate localDate = LocalDate.parse(request.getDateReservation().substring(0, 10)); // "2025-08-08"

            // Convertir en java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

            reservation.setDateReservation(sqlDate);

        } catch (Exception e) {
            throw new RuntimeException("Format de date invalide. Attendu : yyyy-MM-dd ou yyyy-MM-dd'T'HH:mm:ss");
        }

        Reservation savedReservation = reservationService.createReservation(reservation);

        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    @PutMapping("/reservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {

        System.out.println("coucou Update");
        if (reservation.getPrixFinal() == 0.0 && reservation.getDateReservation() != null) {
            System.out.println("modification effectuer");
        }

        Reservation updateReservation = reservationService.updateReservation(id, reservation);

        if (updateReservation != null) {
            return ResponseEntity.ok(updateReservation);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable Long id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeErrorException e) {
            return ResponseEntity.notFound().build();
        }
    }
}