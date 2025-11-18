package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.enumerations.eStatutImpression;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table (name = "Impression")
@Entity
@Data

public class Impression {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Demande Demande_conserne;
    private Date start_date;
    private Date end_date;
    private eStatutImpression status;
    private String listeproduction;
}
