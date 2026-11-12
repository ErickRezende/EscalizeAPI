package com.erickrezende.musicsapi.auth.dto;

public record LoginRequest(
    String email,
    String password
) {}