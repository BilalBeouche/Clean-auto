package com.clean.auto.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.entity.Vehicule;
import com.clean.auto.backend.repository.VehiculeRepository;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Vehicule saveVehicule(Vehicule vehicule) {
        // Implementation for saving a vehicule
        return vehiculeRepository.save(vehicule); // Placeholder return statement
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        // Implementation for retrieving all vehicules
        return vehiculeRepository.findAll(); // Placeholder return statement
    }

    @Override
    public List<Vehicule> getVehiclesByUser(Users user) {
        return vehiculeRepository.findByUser(user);
    }

}
