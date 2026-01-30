package com.clean.auto.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Role;
import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.enums.RoleType;
import com.clean.auto.backend.exception.ResourceAlreadyExistsException;
import com.clean.auto.backend.repository.RoleRepository;
import com.clean.auto.backend.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;

    }

    @Override
    public Users saveUser(Users user) {
        Optional<Users> existingUser = usersRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new ResourceAlreadyExistsException("Adresse mail déjà existante : " + user.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());

        // rôle par defaut à l'inscription
        Role roleUtilisateur = roleRepository.findByTypeRole(RoleType.UTILISATEUR)
                .orElseThrow(() -> new RuntimeException("Rôle par défaut non trouvé"));
        user.setRole(roleUtilisateur);

        return usersRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public Users updateUser(Long id, Users user) {
        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'id : " + id));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail().toLowerCase());
        existingUser.setPhoneNumber(user.getPhoneNumber());

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        System.out.println("Mot de passe encodé en base : " + user.getPassword());

        return usersRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        if (!usersRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur introuvable");
        } else {
            usersRepository.deleteById(id);
            System.out.println("Utilisateur supprimé avec succès : " + id);
        }
    }

    public Users getCurrentUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        return usersRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }
}