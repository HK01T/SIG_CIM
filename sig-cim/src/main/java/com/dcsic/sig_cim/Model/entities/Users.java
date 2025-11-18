package com.dcsic.sig_cim.Model.entities;

import com.dcsic.sig_cim.Model.enumerations.eStructure;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;



@Entity
@Table (name= "users")
@Data
public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)


    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String role;
    private eStructure structure;

    @OneToMany(mappedBy = "user")
    private List<Demande> demande;

    @OneToOne(mappedBy = "user")
    private  Etat_majors etat_majors;

}
