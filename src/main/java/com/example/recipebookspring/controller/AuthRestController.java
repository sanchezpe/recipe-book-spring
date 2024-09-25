package com.example.recipebookspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestController {
    private final InMemoryUserDetailsManager userDetailsService;
    private final PasswordEncoder passwordEncoder;

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
}
