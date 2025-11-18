package com.dcsic.sig_cim.Model.entities.Repository;

import com.dcsic.sig_cim.Model.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, String > {
    List<Demande> findByUserId(Long id);
}
