package com.akram.spring.tms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Véhicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String modele;
    private String immatriculation;
    private boolean disponible = true;

    @JsonIgnore  //Empêche la boucle infinie
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<Trajet> trajets;

    public Vehicule(Long id, String marque, String modele, String immatriculation, boolean disponible) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.immatriculation = immatriculation;
        this.disponible = disponible;
        this.trajets = null;  // On ne met pas `trajets` pour éviter des erreurs de mapping
    }




}
