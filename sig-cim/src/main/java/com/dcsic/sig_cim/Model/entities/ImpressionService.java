package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.entities.Repository.DemandeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ImpressionService {
    private final DemandeRepository demandeRepository;

    @Autowired
    public ImpressionService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }
}
