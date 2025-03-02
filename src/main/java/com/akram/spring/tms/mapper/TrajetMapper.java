package com.akram.spring.tms.mapper;

import com.akram.spring.tms.dto.TrajetDto;
import com.akram.spring.tms.entity.Trajet;

public class TrajetMapper {
    public static TrajetDto mapToTrajetDto(Trajet trajet) {
        return new TrajetDto(
                trajet.getId(),
                trajet.getPointDepart(),
                trajet.getPointArrivee(),
                trajet.getDateDepart(),
                trajet.getDateArrivee(),
                trajet.getConducteur().getId(),
                trajet.getVehicule().getId()
        );
    }

    public static Trajet mapToTrajet(TrajetDto trajetDto) {
        Trajet trajet = new Trajet();
        trajet.setId(trajetDto.getId());
        trajet.setPointDepart(trajetDto.getPointDepart());
        trajet.setPointArrivee(trajetDto.getPointArrivee());
        trajet.setDateDepart(trajetDto.getDateDepart());
        trajet.setDateArrivee(trajetDto.getDateArrivee());
        
        return trajet;
    }
}
