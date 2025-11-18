package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.entities.Repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private DemandeService demandeService;

    @Autowired
    public AdminController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @GetMapping("/demandes")
    public ResponseEntity<List<Demande>> getAllDemandes() {
        return ResponseEntity.ok(demandeService.getAllDemandes());
    }
    @PostMapping("/demandes")
    public ResponseEntity<Demande> createDemande(@RequestBody Demande demande) {
        return new ResponseEntity<>(demandeService.createDemande(demande), HttpStatus.CREATED);
    }
    @DeleteMapping("/demandes")
    public ResponseEntity<Demande> deleteDemande(@RequestBody Demande demande) {
        return new ResponseEntity<>(demandeService.deleteDemande(demande), HttpStatus.OK);
    }
}

