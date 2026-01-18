package com.clean.auto.backend.DTO;

public class ReservationRequestDTO {
    private Long idVehicule;
    private Long idPrestation;
    private String dateReservation; // sous forme de string JSON
    private double prixFinal;

    public ReservationRequestDTO(Long idVehicule, Long idPrestation, String dateReservation, double prixFinal) {
        this.idVehicule = idVehicule;
        this.idPrestation = idPrestation;
        this.dateReservation = dateReservation;
        this.prixFinal = prixFinal;

    }

    public Long getIdVehicule() {
        return idVehicule;
    }

    public Long getIdPrestation() {
        return idPrestation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public double getPrixFinal() {
        return prixFinal;
    }

}
