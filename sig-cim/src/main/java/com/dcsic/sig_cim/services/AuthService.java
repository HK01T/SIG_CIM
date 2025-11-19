package com.dcsic.sig_cim.services;

import com.dcsic.sig_cim.Model.entities.Repository.UsersRepository;
import com.dcsic.sig_cim.Model.entities.Users;
import com.dcsic.sig_cim.Model.enumerations.eRole;
import com.dcsic.sig_cim.dto.AuthRequest;
import com.dcsic.sig_cim.dto.AuthResponse;
import com.dcsic.sig_cim.dto.RegisterRequest;
import com.dcsic.sig_cim.security.CustomUserDetails;
import com.dcsic.sig_cim.security.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsersRepository repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtUtils jwt;

    public AuthService(UsersRepository repo, PasswordEncoder encoder,
                       AuthenticationManager authManager, JwtUtils jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwt = jwt;
    }

    public String register(RegisterRequest req) {
        if (repo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Users u = new Users();
        u.setNom(req.getNom());
        u.setPrenom(req.getPrenom());
        u.setEmail(req.getEmail());
        u.setPassword(encoder.encode(req.getPassword()));

        if (req.getRole() != null) {
            u.setRole(eRole.valueOf(req.getRole()));
        } else {
            u.setRole(eRole.ROLE_USER);
        }

        repo.save(u);
        return "User registered";
    }

    public AuthResponse login(AuthRequest req) {
        var authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        String token = jwt.generateToken(user);

        return new AuthResponse(token, user.getUsername());
    }
}