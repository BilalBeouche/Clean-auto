package com.clean.auto.backend.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clean.auto.backend.DTO.UpdateUserDto;
import com.clean.auto.backend.DTO.UsersResponse;
import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public Users createUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @GetMapping("/allUsers")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable Long id) {
        Users user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user); // 200 OK avec user en body
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {

        Users updatedUser = userService.updateUser(id, user);

        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found si l'utilisateur n'existe pas
        }
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('isAuthenticated()')")
    public UsersResponse getMe(Authentication authentication) {

        // String email = authentication.getName(); // ✅ vient du JWT
        Users user = userService.getCurrentUsers();

        return new UsersResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber());
    }

    @PutMapping("/updateMe")
    public ResponseEntity<Users> updateCurrentUser(@RequestBody UpdateUserDto dto) {

        Users updateUser = userService.updateCurrentUser(dto);
        if (updateUser != null) {
            return ResponseEntity.ok(updateUser);
        } else {
            return ResponseEntity.notFound().build();
        }
        // return ResponseEntity.ok(updateUser);
    }

}