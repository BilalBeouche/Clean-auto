package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Avis;

@Service
public interface AvisService {

    Avis createAvis(Avis avis);

    List<Avis> getAllAvis();

    Avis updateAvis(Long id, Avis avis);

    void deleteAvis(Long id);
}
