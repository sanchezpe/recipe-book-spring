package com.example.recipebookspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestController {
    private final InMemoryUserDetailsManager userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;

    @PostMapping("/createUser")
    public void createUser(@RequestBody UserDto userDto) {
        userDetailsService.createUser(
                User.builder()
                        .username(userDto.username())
                        .password(userDto.password())
                        .passwordEncoder(passwordEncoder::encode)
                        .build()
        );
    }

    public record UserDto(String username, String password) {
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestParam String username, @RequestParam String password) {
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        return "jwtToken";
    }
}
