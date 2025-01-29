package com.akram.spring.tms.dto;

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
    private String nom; // Nom du conducteur
    private String prenom; // Prénom du conducteur
    private String permis; // Numéro de permis de conduire
}
