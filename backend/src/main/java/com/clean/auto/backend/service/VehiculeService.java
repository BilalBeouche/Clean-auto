package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.entity.Vehicule;

@Service
public interface VehiculeService {

    Vehicule saveVehicule(Vehicule vehicule);

    List<Vehicule> getAllVehicules();

    List<Vehicule> getVehiclesByUser(Users user);
}
