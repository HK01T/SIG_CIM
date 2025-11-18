package com.dcsic.sig_cim.Model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Historique")
@Data
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Impression impression_realiser;
    private Date start_date;
    private Date end_date;

    @OneToOne(mappedBy = "historique")
    private Etat_majors etat_majors;
 }

