package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Avis;
import com.clean.auto.backend.entity.Reservation;
import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.repository.AvisRepository;
import com.clean.auto.backend.repository.ReservationRepository;

@Service
public class AvisServiceImpl implements AvisService {

    private final AvisRepository avisRepository;
    private final ReservationRepository reservationRepository;

    private final UserService userService;

    public AvisServiceImpl(AvisRepository avisRepository, UserService userService,
            ReservationRepository reservationRepository) {
        this.avisRepository = avisRepository;
        this.reservationRepository = reservationRepository;

        this.userService = userService;
    }

    @Override
    public Avis createAvis(Avis avis) {

        Users user = userService.getCurrentUsers();
        avis.setUsers(user);

        if (avis.getReservation() != null && avis.getReservation().getIdReservation() != null) {

            Reservation reservation = reservationRepository
                    .findById(avis.getReservation().getIdReservation())
                    .orElseThrow(() -> new RuntimeException("Réservation introuvable"));

        } else {

            avis.setReservation(null);
        }

        avis.setNote(avis.getNote());
        avis.setCommentaire(avis.getCommentaire());

        return avisRepository.save(avis);
    }

    @Override
    public List<Avis> getAllAvis() {
        // TODO Auto-generated method stub
        return avisRepository.findAll();
    }

    @Override
    public Avis updateAvis(Long id, Avis avis) {

        Users user = userService.getCurrentUsers();

        Avis existingaAvis = avisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avis non trouvé avec l'id" + id));

        if (!avis.getUsers().getId().equals(user.getId())) {
            throw new RuntimeException("Vous ne pouvez modifier que votre propre avis");
        }

        existingaAvis.setCommentaire(avis.getCommentaire());
        existingaAvis.setNote(avis.getNote());
        existingaAvis.setGetDateAvis(avis.getDateAvis());

        return avisRepository.save(existingaAvis);
    }

    @Override
    public void deleteAvis(Long id) {
        if (!avisRepository.existsById(id)) {
            throw new RuntimeException("utilsateur introuvable");

        } else {
            avisRepository.deleteById(id);
            System.out.println("utilisateur trouvé" + id);
        }

    }

}
