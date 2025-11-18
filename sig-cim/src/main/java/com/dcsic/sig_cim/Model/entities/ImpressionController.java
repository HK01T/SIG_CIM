package com.dcsic.sig_cim.Model.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/impression")
public class ImpressionController {

    final DemandeService demandeService;

    @Autowired
    public ImpressionController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @GetMapping("/demandes")
    public List<Demande> getAllDemandes() {
        return demandeService.getAllDemandes();
    }

   }
