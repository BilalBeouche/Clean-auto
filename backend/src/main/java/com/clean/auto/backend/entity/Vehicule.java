package com.clean.auto.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private Users user;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "modele", nullable = false)
    private String modele;

    public Vehicule() {
    }

    public Vehicule(Users user, String type, String marque, String modele) {
        this.user = user;
        this.type = type;
        this.marque = marque;
        this.modele = modele;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getId() {
        return idVehicule;
    }

    public void setId(Long id) {
        this.idVehicule = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "idVehicule=" + idVehicule +
                ", user=" + user +
                ", type='" + type + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                '}';
    }
}