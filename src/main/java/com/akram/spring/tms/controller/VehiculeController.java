package com.akram.spring.tms.controller;

import com.akram.spring.tms.dto.VehiculeDto;
import com.akram.spring.tms.service.VehiculeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@AllArgsConstructor
public class VehiculeController {

    private final VehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<VehiculeDto> creerVehicule(@RequestBody VehiculeDto vehiculeDto) {
        VehiculeDto nouveauVehicule = vehiculeService.creerVehicule(vehiculeDto);
        return new ResponseEntity<>(nouveauVehicule, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehiculeDto>> getAllVehicules() {
        List<VehiculeDto> vehicules = vehiculeService.getAllVehicules();
        return ResponseEntity.ok(vehicules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculeDto> getVehiculeById(@PathVariable Long id) {
        VehiculeDto vehicule = vehiculeService.getVehiculeById(id);
        return ResponseEntity.ok(vehicule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculeDto> updateVehicule(@PathVariable Long id, @RequestBody VehiculeDto vehiculeDto) {
        VehiculeDto updatedVehicule = vehiculeService.updateVehicule(id, vehiculeDto);
        return ResponseEntity.ok(updatedVehicule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
        return ResponseEntity.ok("Véhicule supprimé avec succès.");
    }
}
