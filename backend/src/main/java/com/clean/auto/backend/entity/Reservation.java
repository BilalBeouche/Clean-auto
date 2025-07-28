package com.clean.auto.backend.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resevation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idReservation;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false, referencedColumnName = "id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "idVehicule", nullable = false, referencedColumnName = "idVehicule")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "idPrestation", nullable = false, referencedColumnName = "idPrestation")
    private Prestation prestation;

    private Date dateReservation;

    private double prixFinal;

    public Reservation() {

    }

    public Reservation(Users user, Vehicule vehicule, Prestation prestation, Date DateReservation, double prixFinal) {
        this.user = user;
        this.vehicule = vehicule;
        this.prestation = prestation;
        this.dateReservation = DateReservation;
        this.prixFinal = prixFinal;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public double getPrixFinal() {
        return prixFinal;
    }

    public void setPrixFinal(double prixFinal) {
        this.prixFinal = prixFinal;
    }

    @Override
    public String toString() {
        return "Reservation{" + "idReservation=" + idReservation + ", user=" + user + ", vehicule=" + vehicule
                + ", prestation=" + prestation + ", dateReservation=" + dateReservation + ", prixFinal=" + prixFinal
                + '}';
    }

}
