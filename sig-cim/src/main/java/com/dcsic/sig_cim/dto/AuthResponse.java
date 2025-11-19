package com.dcsic.sig_cim.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String email;
    private String type = "Bearer";

    public AuthResponse(String token, String email) {
        this.token = token;
        this.email = email;
    }
}
