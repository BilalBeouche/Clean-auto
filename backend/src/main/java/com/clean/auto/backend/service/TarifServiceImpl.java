package com.clean.auto.backend.service;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Tarif;
import com.clean.auto.backend.repository.TarifRepository;

@Service
public class TarifServiceImpl implements TarifService {

    TarifRepository tarifRepository;

    public TarifServiceImpl(TarifRepository tarifRepository) {
        this.tarifRepository = tarifRepository;
    }

    @Override
    public Tarif saveTarif(Tarif tarif) {
        return tarifRepository.save(tarif);
    }

    @Override
    public Tarif updateTarif(Long id, Tarif tarif) {
        Tarif existingTarif = tarifRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarif not found with id: " + id));
        return tarifRepository.save(existingTarif);
    }

    @Override
    public void deleteTarif(Long idLong) {
        tarifRepository.deleteById(idLong);
    }

    @Override
    public Tarif getTarifByPrestationId(Long prestationId) {
        return tarifRepository.getTarifByPrestationId(prestationId);
    }
}
