package com.example.recipebookspring.service;

import org.springframework.security.core.Authentication;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public interface TokenService {
    Duration expiresIn = Duration.of(1, ChronoUnit.HOURS);

    String generateToken(Authentication authentication);
}
