package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.enumerations.eStructure;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Etats")
@Data
public class Etats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private eStructure structure;
    private Long id_structure;
    private Long nmbre_carte;

}
