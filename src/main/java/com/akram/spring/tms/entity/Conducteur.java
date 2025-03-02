package com.akram.spring.tms.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Conducteur")
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique
    @Column(name = "nom")
    private String nom; // Nom du conducteur
    @Column(name = "prenom")
    private String prenom; // Prénom du conducteur
    @Column(name = "permis")
    private String permis; // Numéro de permis de conduire
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "disponible")
    private boolean disponible = true;

    @JsonIgnore  //Empêche la boucle infinie
    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    private List<Trajet> trajets=null;
    
    
    public Conducteur(Long id, String nom, String prenom, String permis, String telephone,Boolean disponible) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.permis = permis;
        this.telephone = telephone;
        this.disponible=disponible;
        this.trajets = null;  // On ne met pas `trajets` pour éviter des erreurs
    }

   
}
