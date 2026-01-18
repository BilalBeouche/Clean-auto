package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Avis;
import com.clean.auto.backend.repository.AvisRepository;

@Service
public class AvisServiceImpl implements AvisService {

    private final AvisRepository avisRepository;

    public AvisServiceImpl(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;

    }

    @Override
    public Avis saveAvis(Avis avis) {
        // TODO Auto-generated method stub
        return avisRepository.save(avis);
    }

    @Override
    public List<Avis> getAllAvis() {
        // TODO Auto-generated method stub
        return avisRepository.findAll();
    }

    @Override
    public Avis updateAvis(Long id, Avis avis) {

        Avis existingaAvis = avisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avis non trouvé avec l'id" + id));

        existingaAvis.setCommentaire(avis.getCommentaire());
        existingaAvis.setNote(avis.note());
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
