package com.clean.auto.backend.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clean.auto.backend.entity.Avis;
import com.clean.auto.backend.entity.Reservation;
import com.clean.auto.backend.repository.ReservationRepository;
import com.clean.auto.backend.service.AvisService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/avis")
public class AvisController {

    private final AvisService avisService;

    private final ReservationRepository reservationRepository;

    public AvisController(AvisService avisService, ReservationRepository reservationRepository) {
        this.avisService = avisService;
        this.reservationRepository = reservationRepository;

    }

    @PostMapping("/createAvis")
    public ResponseEntity<?> createAvis(@RequestBody Avis avis) {

        if (avis.getReservation() != null && avis.getReservation().getIdReservation() != null) {

            Reservation reservation = reservationRepository
                    .findById(avis.getReservation().getIdReservation())
                    .orElse(null);

            if (reservation == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Reservation introuvable");
            }

            avis.setReservation(reservation);
        }

        Avis avisSaved = avisService.createAvis(avis);
        return ResponseEntity.ok(avisSaved);
    }

    @GetMapping("/allAvis")
    public List<Avis> getAllAvis() {
        return avisService.getAllAvis();
    }

    @PutMapping("/updateAvis/{id}")
    public ResponseEntity<Avis> updateAvis(@PathVariable Long id, @RequestBody Avis avis) {

        Avis updateaAvis = avisService.updateAvis(id, avis);
        System.out.println("UPDATE AVIS");
        if (updateaAvis != null) {
            return ResponseEntity.ok(updateaAvis);

        } else {
            return ResponseEntity.notFound().build();
        }

    }
}