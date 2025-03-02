package com.akram.spring.tms.service;

import com.akram.spring.tms.dto.TrajetDto;
import com.akram.spring.tms.entity.Trajet;

import java.util.List;

public interface TrajetService {
	TrajetDto creerTrajet(TrajetDto trajetDto);
    void terminerTrajet(Long trajetId);
    List<Trajet> getAllTrajets();
    Trajet getTrajetById(Long id);
    TrajetDto updateTrajet(Long id, TrajetDto trajetDto);
    void supprimerTrajet(Long id);
}