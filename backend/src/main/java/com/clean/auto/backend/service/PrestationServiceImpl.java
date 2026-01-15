package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Prestation;
import com.clean.auto.backend.repository.PrestationRepository;

@Service
public class PrestationServiceImpl implements PrestationService {

    @Autowired
    private final PrestationRepository prestationRepository;

    public PrestationServiceImpl(PrestationRepository prestationRepository) {
        this.prestationRepository = prestationRepository;
    }

    @Override
    public List<Prestation> getAllPrestations() {
        return prestationRepository.findAll();
    }

    @Override
    public Prestation savePresta(Prestation prestation) {
        return prestationRepository.save(prestation);
    }

    @Override
    public void deletePresta(Long id) {
        prestationRepository.deleteById(id);
    }

}
