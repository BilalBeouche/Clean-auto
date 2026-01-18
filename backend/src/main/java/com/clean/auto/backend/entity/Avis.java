package com.clean.auto.backend.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "avis")
public class Avis {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idAvis;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idReservation", nullable = true, referencedColumnName = "idReservation")
    private Reservation reservation;

    private int note;

    private String commentaire;

    private Date dateAvis;

    public Avis() {
    }

    public Avis(Reservation reservation, int note, String commentaire, Date dateAvis) {
        this.reservation = reservation;
        this.note = note;
        this.commentaire = commentaire;
        this.dateAvis = dateAvis;
    }

    public Long getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Long idAvis) {
        this.idAvis = idAvis;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDateAvis() {
        return dateAvis;
    }

    public void setGetDateAvis(Date dateAvis) {
        this.dateAvis = dateAvis;
    }

    @Override
    public String toString() {
        return "Avis{" + "idAvis=" + idAvis + ", reservation=" + reservation + ", note=" + note + ", commentaire='"
                + commentaire + '\'' + ", dateAvis=" + dateAvis + '}';
    }

}
