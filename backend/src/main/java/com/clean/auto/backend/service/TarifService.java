package com.clean.auto.backend.service;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Tarif;

@Service
public interface TarifService {

    Tarif getTarifByPrestationId(Long prestationId);

    Tarif saveTarif(Tarif tarif);

    Tarif updateTarif(Long id, Tarif tarif);

    void deleteTarif(Long id);

}
