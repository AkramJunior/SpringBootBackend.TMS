package com.akram.spring.tms.service.impl;

import com.akram.spring.tms.dto.VehiculeDto;
import com.akram.spring.tms.entity.Vehicule;
import com.akram.spring.tms.exception.ResourceNotFoundException;
import com.akram.spring.tms.mapper.VehiculeMapper;
import com.akram.spring.tms.repository.VehiculeRepository;
import com.akram.spring.tms.service.VehiculeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    @Override
    public VehiculeDto creerVehicule(VehiculeDto vehiculeDto) {
        Vehicule vehicule = VehiculeMapper.mapToVehicule(vehiculeDto);
        Vehicule savedVehicule = vehiculeRepository.save(vehicule);
        return VehiculeMapper.mapToVehiculeDto(savedVehicule);
    }

    @Override
    public List<VehiculeDto> getAllVehicules() {
        return vehiculeRepository.findAll()
                .stream()
                .map(VehiculeMapper::mapToVehiculeDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculeDto getVehiculeById(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule non trouvé"));
        return VehiculeMapper.mapToVehiculeDto(vehicule);
    }

    @Override
    public VehiculeDto updateVehicule(Long id, VehiculeDto vehiculeDto) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule non trouvé"));
        vehicule.setMarque(vehiculeDto.getMarque());
        vehicule.setModele(vehiculeDto.getModele());
        vehicule.setImmatriculation(vehiculeDto.getImmatriculation());
        vehicule.setDisponible(vehiculeDto.isDisponible());
        Vehicule updatedVehicule = vehiculeRepository.save(vehicule);
        return VehiculeMapper.mapToVehiculeDto(updatedVehicule);
    }

    @Override
    public void deleteVehicule(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule non trouvé"));
        vehiculeRepository.delete(vehicule);
    }
}
