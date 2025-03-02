package com.akram.spring.tms.controller;

import com.akram.spring.tms.dto.TrajetDto;
import com.akram.spring.tms.entity.Trajet;
import com.akram.spring.tms.service.TrajetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trajets")
@AllArgsConstructor
public class TrajetController {

    private final TrajetService trajetService;

    @PostMapping
    public ResponseEntity<TrajetDto> creerTrajet(@RequestBody TrajetDto trajetDto) {
        TrajetDto nouveauTrajet = trajetService.creerTrajet(trajetDto);
        return new ResponseEntity<>(nouveauTrajet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/terminer")
    public ResponseEntity<String> terminerTrajet(@PathVariable Long id) {
        trajetService.terminerTrajet(id);
        return ResponseEntity.ok("Trajet terminé avec succès, le conducteur et le véhicule sont maintenant disponibles.");
    }

    @GetMapping
    public ResponseEntity<List<Trajet>> getAllTrajets() {
        List<Trajet> trajets = trajetService.getAllTrajets();
        return ResponseEntity.ok(trajets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trajet> getTrajetById(@PathVariable Long id) {
        Trajet trajet = trajetService.getTrajetById(id);
        return ResponseEntity.ok(trajet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrajetDto> modifierTrajet(@PathVariable Long id, @RequestBody TrajetDto trajetDto) {
    	TrajetDto updatedTrajet = trajetService.updateTrajet(id, trajetDto);
        return ResponseEntity.ok(updatedTrajet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerTrajet(@PathVariable Long id) {
        trajetService.supprimerTrajet(id);
        return ResponseEntity.ok("Trajet supprimé avec succès.");
    }
}
