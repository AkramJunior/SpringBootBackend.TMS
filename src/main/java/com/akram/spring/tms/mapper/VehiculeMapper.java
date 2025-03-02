package com.akram.spring.tms.mapper;

import com.akram.spring.tms.dto.VehiculeDto;
import com.akram.spring.tms.entity.Vehicule;

public class VehiculeMapper {
    public static VehiculeDto mapToVehiculeDto(Vehicule vehicule) {
        return new VehiculeDto(
                vehicule.getId(),
                vehicule.getMarque(),
                vehicule.getModele(),
                vehicule.getImmatriculation(),
                vehicule.isDisponible()
        );
    }

    public static Vehicule mapToVehicule(VehiculeDto vehiculeDto) {
        return new Vehicule(
                vehiculeDto.getId(),
                vehiculeDto.getMarque(),
                vehiculeDto.getModele(),
                vehiculeDto.getImmatriculation(),
                vehiculeDto.isDisponible()
        );
    }
}
