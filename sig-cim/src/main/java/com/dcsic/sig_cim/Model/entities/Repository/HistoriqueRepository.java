package com.dcsic.sig_cim.Model.entities.Repository;

import com.dcsic.sig_cim.Model.entities.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
}
