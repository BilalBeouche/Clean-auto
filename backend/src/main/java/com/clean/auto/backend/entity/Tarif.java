package com.clean.auto.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarif")
public class Tarif {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idTarifs;

    @ManyToOne
    @JoinColumn(name = "id_prestation", nullable = false, referencedColumnName = "idPrestation")
    private Prestation prestation;

    private String vehicule_type;

    private Double price;

    public Tarif() {
    }

    public Tarif(Prestation prestation, String vehicule_type, Double price) {
        this.prestation = prestation;
        this.vehicule_type = vehicule_type;
        this.price = price;
    }

    public Long getIdTarifs() {
        return idTarifs;
    }

    public void setIdTarifs(Long idTarifs) {
        this.idTarifs = idTarifs;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void SetPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public String getVehicule_type() {
        return vehicule_type;
    }

    public void setVehicule_type(String vehicule_type) {
        this.vehicule_type = vehicule_type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tarif{" + "idTarifs=" + idTarifs + ", prestation=" + prestation + ", vehicule_type='" + vehicule_type
                + '\'' + ", price=" + price + '}';
    }
}
