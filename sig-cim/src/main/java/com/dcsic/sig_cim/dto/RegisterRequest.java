package com.dcsic.sig_cim.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String role;
}
