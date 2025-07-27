package com.clean.auto.backend.config;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.clean.auto.backend.entity.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private final String KEY_SECRET = "27072025";

    public String generateToken(Users user) {

        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, KEY_SECRET)
                .compact();

    }
}