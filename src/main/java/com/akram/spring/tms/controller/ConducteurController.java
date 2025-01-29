package com.akram.spring.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.akram.spring.tms.dto.ConducteurDto;
import com.akram.spring.tms.service.ConducteurService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/conducteurs")
public class ConducteurController {

    @Autowired
    private ConducteurService conducteurService;

    // Ajouter un nouveau conducteur (Build Add Conducteur REST API)
    @PostMapping
    public ResponseEntity<ConducteurDto> addConducteur(@RequestBody ConducteurDto conducteurDto) {
        ConducteurDto savedConducteur =conducteurService.addConducteur(conducteurDto);
		return new ResponseEntity<>(savedConducteur, HttpStatus.CREATED);
    } 
    
    
    // Récupérer un conducteur par ID (Build Get Conducteur REST API)
    @GetMapping("{id}")
    public ResponseEntity<ConducteurDto> getConducteurById(@PathVariable("id") Long conducteurId){
    	ConducteurDto conducteurDto= conducteurService.getConducteurById(conducteurId);
        return ResponseEntity.ok(conducteurDto);
    }
    
    
 // Récupérer tous les conducteurs (Build Get All conducteurs REST API)
    @GetMapping
    public ResponseEntity<List<ConducteurDto>> getAllConducteurs() {
        List <ConducteurDto> conducteurs=conducteurService.getAllConductures();
        return ResponseEntity.ok(conducteurs);
    }
    
    
 // modifier un conducteur (Build Update Conducteur REST API)
    @PutMapping("{id}")
    public ResponseEntity<ConducteurDto> updateConducteur(@PathVariable("id") Long conducteurId ,@RequestBody ConducteurDto updatedconducteurDto) {
        ConducteurDto conducteurDto =conducteurService.updateConducteur(conducteurId, updatedconducteurDto);
        return ResponseEntity.ok(conducteurDto);
    } 
    
    
 // supprimer un conducteur (Build Delete Conducteur REST API)
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteConducteur(@PathVariable("id") Long conducteurId) {
        conducteurService.deleteConducteur(conducteurId);
        return ResponseEntity.ok("Le Conducteur est supprimé");
    } 
    
    
    
    
    
    
    
    
}