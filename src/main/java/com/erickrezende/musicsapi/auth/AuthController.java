package com.erickrezende.musicsapi.auth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.erickrezende.musicsapi.auth.dto.AuthResponse;
import com.erickrezende.musicsapi.auth.dto.LoginRequest;
import com.erickrezende.musicsapi.auth.dto.SignupRequest;
import com.erickrezende.musicsapi.user.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/me")
    public User me(@AuthenticationPrincipal User user) {
        return user;
    }
}