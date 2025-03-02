package com.akram.spring.tms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConducteurDto {
	private Long id; // Identifiant unique
	 @JsonProperty("nom") // Map le champ JSON "lastName"
	private String nom; // Nom du conducteur
    @JsonProperty("prenom") // Map le champ JSON "firstName"
    private String prenom; // Prénom du conducteur
    @JsonProperty("permis") // Map le champ JSON "licenseNumber" 
    private String permis; // Numéro de permis de conduire
    @JsonProperty("telephone") // Map le champ JSON "phone"
    private String telephone;
    @JsonProperty("disponible") // Map le champ JSON "disponible"
    private boolean disponible;
}
