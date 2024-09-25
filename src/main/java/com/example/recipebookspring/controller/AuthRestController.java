package com.example.recipebookspring.controller;

import com.example.recipebookspring.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private final AuthenticationProvider authenticationProvider;
    private final TokenService tokenService;

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

    @PostMapping("/generateToken")
    public AuthResponse generateToken(@RequestBody UserDto userDto) {
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.username(), userDto.password())
        );
        return new AuthResponse(tokenService.generateToken(authentication));
    }

    public record UserDto(String username, String password) {
    }

    public record AuthResponse(String token) {
    }
}
