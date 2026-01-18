package com.clean.auto.backend.entity;

import com.clean.auto.backend.enums.PrestationType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestation")
public class Prestation {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idPrestation;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_prestation", nullable = false)
    private PrestationType namePrestation;

    @Column(name = "description", nullable = true)
    private String description;

    public Prestation() {
    }

    public Prestation(PrestationType namePrestation, String Description) {
        this.namePrestation = namePrestation;
        this.description = Description;
    }

    @OneToOne(mappedBy = "prestation", cascade = CascadeType.ALL)
    private Tarif tarif;

    public Long getId() {
        return idPrestation;
    }

    public void setId(Long id) {
        this.idPrestation = id;
    }

    public PrestationType getNamePrestation() {
        return namePrestation;
    }

    public void setNamePrestation(PrestationType namePrestation) {
        this.namePrestation = namePrestation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Prestation{" + "idPrestation=" + idPrestation + ", namePrestation=" + namePrestation
                + ", description='" + description + '\'' + '}';
    }

}
