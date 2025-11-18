package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.enumerations.eTypeCommandant;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Commandant")
@Data
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private eTypeCommandant eTypeCommandant;

    @OneToOne
    @JoinColumn(name = "demande_id" )
    private Demande demande;






    }