package com.akram.spring.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeDto {
    private Long id;
    private String marque;
    private String modele;
    private String immatriculation;
    private boolean disponible;
}
