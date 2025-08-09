package com.clean.auto.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.entity.Vehicule;
import com.clean.auto.backend.repository.UsersRepository;
import com.clean.auto.backend.service.VehiculeService;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    @Autowired
    private final VehiculeService vehiculeService;
    @Autowired
    private final UsersRepository usersRepository;

    public VehiculeController(VehiculeService vehiculeService, UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.vehiculeService = vehiculeService;
    }

    @GetMapping("/mesVehicules")
    public List<Vehicule> getMyVehicles() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        return vehiculeService.getVehiclesByUser(user);
    }

    @PostMapping("/monVehicule")
    public ResponseEntity<Vehicule> addMyVehicule(@RequestBody Vehicule vehicule) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        vehicule.setUser(user);

        Vehicule saveVehicule = vehiculeService.saveVehicule(vehicule);

        return new ResponseEntity<>(saveVehicule, HttpStatus.CREATED);
    }

}
