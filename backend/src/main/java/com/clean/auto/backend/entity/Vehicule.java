package com.clean.auto.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idVehicule;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "modele", nullable = false)
    private String modele;

    public Vehicule() {
    }

    public Vehicule(Users users, String type, String marque, String modele) {
        this.users = users;
        this.type = type;
        this.marque = marque;
        this.modele = modele;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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
        return "Vehicule{" + "idVehicule=" + idVehicule + ", users=" + users + ", type='" + type + '\'' + ", marque='"
                + marque + '\'' + ", modele='" + modele + '\'' + '}';
    }

}
