package com.akram.spring.tms.service;

import com.akram.spring.tms.dto.VehiculeDto;
import java.util.List;

public interface VehiculeService {
    VehiculeDto creerVehicule(VehiculeDto vehiculeDto);
    List<VehiculeDto> getAllVehicules();
    VehiculeDto getVehiculeById(Long id);
    VehiculeDto updateVehicule(Long id, VehiculeDto vehiculeDto);
    void deleteVehicule(Long id);
}
