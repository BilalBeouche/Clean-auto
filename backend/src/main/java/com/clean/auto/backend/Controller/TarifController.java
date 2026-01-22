package com.clean.auto.backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clean.auto.backend.entity.Tarif;
import com.clean.auto.backend.service.TarifService;

@RestController
@RequestMapping("/api/tarifs")
public class TarifController {

    TarifService tarifService;

    public TarifController(TarifService tarifService) {
        this.tarifService = tarifService;
    }

    @PostMapping("/createTarif")
    public ResponseEntity<?> createTarif(@RequestBody Tarif tarif) {
        Tarif tarifSaved = tarifService.saveTarif(tarif);
        System.out.println("Tarif saved: " + tarifSaved);
        return ResponseEntity.ok(tarifSaved);
    }

    @DeleteMapping("/deleteTarif")
    public ResponseEntity<?> deleteById(@RequestBody Long idTarif) {
        this.tarifService.deleteTarif(idTarif);
        return ResponseEntity.ok("Tarif deleted successfully");
    }

}
