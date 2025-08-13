package com.clean.auto.backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clean.auto.backend.entity.Avis;
import com.clean.auto.backend.entity.Reservation;
import com.clean.auto.backend.repository.ReservationRepository;
import com.clean.auto.backend.service.AvisService;

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
        if (avis.getReservation() == null || avis.getReservation().getIdReservation() == null) {
            return ResponseEntity.badRequest().body("reservation non trouvé");
        }

        Reservation reservation = reservationRepository.findById(avis.getReservation().getIdReservation())
                .orElseThrow(() -> new RuntimeException("Reservation introuvable"));

        avis.setReservation(reservation);
        Avis avisSaved = avisService.saveAvis(avis);

        return ResponseEntity.ok(avisSaved);

    }

}