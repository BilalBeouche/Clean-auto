// dans GlobalExceptionHandler.java
package com.clean.auto.backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    // Gère l'erreur d'un utilisateur déjà existant
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<Object> handleResourceAlreadyExists(ResourceAlreadyExistsException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT); // <-- Renvoie 409 Conflict
    }

    // Gère l'erreur d'un mot de passe ou email incorrect
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("error", "Unauthorized");
        body.put("message", "Email ou mot de passe invalide !");

        // Cette méthode sera maintenant appelée
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED); 
    }

    // Gardez un gestionnaire général pour les autres erreurs imprévues
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        // CETTE LIGNE VA IMPRIMER LA VRAIE ERREUR DANS VOTRE CONSOLE
        System.out.println("Une exception inattendue a été interceptée : " + ex);

        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message", "Une erreur inattendue est survenue.");
        
        // Pour le débogage, vous pouvez même inclure le nom de l'exception dans la réponse
        // ATTENTION : Ne faites pas ça en production
        body.put("exception_type", ex.getClass().getName());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}