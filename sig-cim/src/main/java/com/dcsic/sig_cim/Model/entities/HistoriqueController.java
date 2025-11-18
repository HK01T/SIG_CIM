package com.dcsic.sig_cim.Model.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/historique")
public class HistoriqueController {


    @Autowired
    private HistoriqueService historiqueService;

    @GetMapping("/realiser")
    public List<Historique> getHistorique() {
        return historiqueService.getImpressions();
    }


}
