package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.entities.Repository.DemandeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class DemandeService {

    private final DemandeRepository demandeRepository;

    @Autowired
    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }
    public DemandeRepository getDemandeRepository() {
        return demandeRepository;
    }
    public Demande createDemande(Demande demande) {
        return demandeRepository.save(demande);
    }
    public Demande updateDemande(Demande demande) {
        return demandeRepository.save(demande);
    }
    public Demande deleteDemande(Demande demande) {
        demandeRepository.delete(demande);
        return demande;
    }

    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }
}
