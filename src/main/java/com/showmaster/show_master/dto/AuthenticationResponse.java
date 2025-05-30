package com.showmaster.show_master.dto;

public class AuthenticationResponse {
    private final String jwt;
    private final String username;

    public AuthenticationResponse(String jwt, String username) {
        this.jwt = jwt;
        this.username = username;
    }

    public String getJwt() {
        return jwt;
    }

    public String getUsername() {
        return username;
    }
}
