package com.erickrezende.musicsapi.auth;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.erickrezende.musicsapi.auth.dto.AuthResponse;
import com.erickrezende.musicsapi.auth.dto.LoginRequest;
import com.erickrezende.musicsapi.auth.dto.SignupRequest;
import com.erickrezende.musicsapi.auth.dto.UserResponse;
import com.erickrezende.musicsapi.auth.jwt.JwtService;
import com.erickrezende.musicsapi.user.User;
import com.erickrezende.musicsapi.user.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse signup(SignupRequest request) {

        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Email já cadastrado"
            );
        }

        User user = new User();

        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setAdmin(request.admin());
        user.setRoles(request.roles());

        User savedUser = userRepository.save(user);

        String token = jwtService.generateToken(savedUser.getId());

        return new AuthResponse(
            token,
            new UserResponse(savedUser.getName(), savedUser.getEmail())
        );
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email())
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Credenciais inválidas"
            ));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Credenciais inválidas"
            );
        }

        String token = jwtService.generateToken(user.getId());

        return new AuthResponse(
            token,
            new UserResponse(user.getName(), user.getEmail())
        );
    }
}