package com.clean.auto.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.repository.UsersRepository;
import com.clean.auto.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public UserService userService;
    public UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, UsersRepository usersRepository) {
        this.userService = userService;
        this.usersRepository = usersRepository;
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        // Check if the user already exists
        Users existingUser = usersRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("User already exists with email: " + user.getEmail());
        }
        // If the user does not exist, save the new user
        user.setPassword(passwordEncoder.encode(user.getPassword())); // You might want to hash the password here
        user.setEmail(user.getEmail().toLowerCase());

        // Normalize email to lowercase
        return userService.saveUser(user); // Save the user and return the saved user
    }

    @PostMapping("/login")
    public Users login(@RequestBody Users user) {
        System.out.println("Tentative login pour email: " + user.getEmail());
        Users existingUser = usersRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            System.out.println("Utilisateur non trouvé !");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe invalide !");
        }
        System.out.println("Utilisateur trouvé. Vérification mot de passe...");
        boolean matches = passwordEncoder.matches(user.getPassword(), existingUser.getPassword());
        System.out.println("Mot de passe correspond ? " + matches);
        if (matches) {
            return existingUser;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe invalide !");
        }
    }

}
