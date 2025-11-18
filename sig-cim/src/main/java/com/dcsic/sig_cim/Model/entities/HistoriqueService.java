package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.entities.Repository.HistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueService {


    @Autowired
    private HistoriqueRepository historiqueRepository;

    public List<Historique> getImpressions() {
        return historiqueRepository.findAll();

    }
}
