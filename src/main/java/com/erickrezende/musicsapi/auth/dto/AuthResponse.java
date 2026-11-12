package com.erickrezende.musicsapi.auth.dto;

public record AuthResponse(
    String token,
    UserResponse user
) {}