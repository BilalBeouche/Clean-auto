package com.clean.auto.backend.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clean.auto.backend.entity.Users;
import com.clean.auto.backend.repository.UsersRepository;
import com.clean.auto.backend.securite.CustomUserDetails;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     private final UsersRepository usersRepository;

//     public CustomUserDetailsService(UsersRepository usersRepository) {
//         this.usersRepository = usersRepository;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         Users user = usersRepository.findByEmail(email)
//                 .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email));
//         if (user == null) {
//             throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email);
//         }
//         return new org.springframework.security.core.userdetails.User(
//             user.getEmail(), 
//             user.getPassword(),
//                 new ArrayList<>());
//     }

// }

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Utilisateur non trouvé avec l'email : " + email));

        return new CustomUserDetails(user); // 🔥 LA LIGNE CLÉ
    }
}
