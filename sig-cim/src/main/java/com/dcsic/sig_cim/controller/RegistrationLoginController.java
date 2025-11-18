package com.dcsic.sig_cim.controller;

import com.dcsic.sig_cim.Model.entities.Repository.UsersRepository;
import com.dcsic.sig_cim.Model.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegistrationLoginController {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
  @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) throws Exception {
        if (usersRepository.findByEmail(user.getEmail()) != null){
            return ResponseEntity.badRequest().body("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(usersRepository.save(user));
  }

  @PostMapping ("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user) throws Exception {

      try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
          System.out.println("connexion reussie");
          Map<String, String> response = new HashMap<>();
          response.put("message", "Logged in successfully");
          return ResponseEntity.ok(response);

        } catch (Exception ex) {
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
      }
  }
}
