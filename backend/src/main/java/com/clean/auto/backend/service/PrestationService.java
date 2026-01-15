package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Prestation;

@Service
public interface PrestationService {

    List<Prestation> getAllPrestations();

    Prestation savePresta(Prestation prestation);

    void deletePresta(Long id);
}