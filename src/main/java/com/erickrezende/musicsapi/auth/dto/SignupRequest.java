package com.erickrezende.musicsapi.auth.dto;

import java.util.List;

public record SignupRequest(
    String name,
    String email,
    String password,
    boolean admin,
    List<String> roles
) {}