package com.clean.auto.backend.entity;

import com.clean.auto.backend.enums.TypeVehicule;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeVehicule typeVehicule;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "modele", nullable = false)
    private String modele;

    public Vehicule() {
    }

    public Vehicule(Users user, TypeVehicule typeVehicule, String marque, String modele) {
        this.user = user;
        this.typeVehicule = typeVehicule;
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

    public TypeVehicule getType() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
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
                ", type='" + typeVehicule + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                '}';
    }
}