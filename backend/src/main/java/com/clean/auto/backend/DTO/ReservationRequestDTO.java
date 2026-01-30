package com.clean.auto.backend.DTO;

import java.time.LocalDate;

public class ReservationRequestDTO {
    private Long idVehicule;
    private Long idPrestation;
    private LocalDate dateReservation; // sous forme de string JSON
    private double prixFinal;

    // ✅ Constructeur vide OBLIGATOIRE
    public ReservationRequestDTO() {
    }

    // (optionnel)
    public ReservationRequestDTO(Long idVehicule, Long idPrestation,
            LocalDate dateReservation, double prixFinal) {
        this.idVehicule = idVehicule;
        this.idPrestation = idPrestation;
        this.dateReservation = dateReservation;
        this.prixFinal = prixFinal;
    }

    public Long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Long idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Long getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(Long idPrestation) {
        this.idPrestation = idPrestation;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public double getPrixFinal() {
        return prixFinal;
    }

    public void setPrixFinal(double prixFinal) {
        this.prixFinal = prixFinal;
    }

}
