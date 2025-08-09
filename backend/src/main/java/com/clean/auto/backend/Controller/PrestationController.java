package com.clean.auto.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clean.auto.backend.entity.Prestation;
import com.clean.auto.backend.service.PrestationService;

@RestController
@RequestMapping("/api/prestations")
public class PrestationController {

    @Autowired
    private final PrestationService prestationService;

    public PrestationController(PrestationService prestationService) {
        this.prestationService = prestationService;
    }

    @GetMapping("/allPrestations")
    public List<Prestation> getAllPrestations() {
        System.out.println("COUCOU");

        // Logique pour récupérer les prestations, éventuellement filtrées
        return prestationService.getAllPrestations();
    }

    @PostMapping("/prestation")
    public ResponseEntity<Prestation> createPresta(@RequestBody Prestation prestation) {

        Prestation savedPrestation = prestationService.savePresta(prestation);
        // TODO: process POST request
        return ResponseEntity.ok(savedPrestation); // Assuming entity is of type Prestation
    }

}
