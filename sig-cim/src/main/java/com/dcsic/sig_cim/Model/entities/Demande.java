package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.enumerations.eStructure;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Demande")
@Data
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @Enumerated(EnumType.STRING)
    private eStructure structure_demande;
    private String fichier_demande;


     @OneToOne(mappedBy = "demande")
     private Administrateur administrateur;

}
