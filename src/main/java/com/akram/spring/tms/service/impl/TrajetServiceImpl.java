package com.akram.spring.tms.service.impl;

import com.akram.spring.tms.dto.TrajetDto;
import com.akram.spring.tms.entity.Conducteur;
import com.akram.spring.tms.entity.Trajet;
import com.akram.spring.tms.entity.Vehicule;
import com.akram.spring.tms.exception.ResourceNotFoundException;
import com.akram.spring.tms.mapper.ConducteurMapper;
import com.akram.spring.tms.mapper.TrajetMapper;
import com.akram.spring.tms.repository.ConducteurRepository;
import com.akram.spring.tms.repository.TrajetRepository;
import com.akram.spring.tms.repository.VehiculeRepository;
import com.akram.spring.tms.service.TrajetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TrajetServiceImpl implements TrajetService {

    private TrajetRepository trajetRepository;
    private  ConducteurRepository conducteurRepository;
    private  VehiculeRepository vehiculeRepository;

    @Override
    @Transactional
    public TrajetDto creerTrajet(TrajetDto trajetDto) {
        Conducteur conducteur = conducteurRepository.findById(trajetDto.getConducteurId())
                .orElseThrow(() -> new ResourceNotFoundException("Conducteur non trouvé"));
        Vehicule vehicule = vehiculeRepository.findById(trajetDto.getVehiculeId())
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule non trouvé"));

        if (!conducteur.isDisponible() || !vehicule.isDisponible()) {
            throw new IllegalStateException("Le conducteur ou le véhicule n'est pas disponible.");
        }
        
        // Marquer le conducteur et le véhicule comme indisponibles
        conducteur.setDisponible(false);
        vehicule.setDisponible(false);
        conducteurRepository.save(conducteur);
        vehiculeRepository.save(vehicule);
        
        Trajet trajet= TrajetMapper.mapToTrajet(trajetDto);
        trajet.setConducteur(conducteur);
        trajet.setVehicule(vehicule);
        
		Trajet saveTrajet= trajetRepository.save(trajet);
	
		return TrajetMapper.mapToTrajetDto(saveTrajet);

        
    }

    @Override
    @Transactional
    public void terminerTrajet(Long trajetId) {
        Trajet trajet = trajetRepository.findById(trajetId)
                .orElseThrow(() -> new ResourceNotFoundException("Trajet non trouvé"));

        Conducteur conducteur = trajet.getConducteur();
        Vehicule vehicule = trajet.getVehicule();

        // Rendre le conducteur et le véhicule disponibles
        conducteur.setDisponible(true);
        vehicule.setDisponible(true);
        conducteurRepository.save(conducteur);
        vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Trajet> getAllTrajets() {
        return trajetRepository.findAll();
    }

    @Override
    public Trajet getTrajetById(Long id) {
        return trajetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trajet non trouvé"));
    }

    @Override
    @Transactional
    public TrajetDto updateTrajet(Long id, TrajetDto trajetDto) {
    	
        Trajet existingTrajet = trajetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trajet non trouvé"));
        Conducteur oldConducteur=existingTrajet.getConducteur();
    	Vehicule oldVehicule=existingTrajet.getVehicule();
        

        // Vérifier si le nouveau conducteur et le nouveau véhicule sont disponibles
        Conducteur conducteur = conducteurRepository.findById(trajetDto.getConducteurId())
                .orElseThrow(() -> new ResourceNotFoundException("Conducteur non trouvé"));
        Vehicule vehicule = vehiculeRepository.findById(trajetDto.getVehiculeId())
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule non trouvé"));

        if((existingTrajet.getConducteur().getId()!=trajetDto.getConducteurId()))
        	if(!conducteur.isDisponible())
			throw new IllegalStateException("Le conducteur n'est pas disponible.");
        	else {
        			// Rendre l'ancien conducteur disponible
		            
		        	oldConducteur.setDisponible(true);
		        	conducteurRepository.save(oldConducteur);
		        	// Assigner le nouveau conducteur 
		            existingTrajet.setConducteur(conducteur);
		            conducteur.setDisponible(false);
		            conducteurRepository.save(conducteur);

        	}
 
        if ((existingTrajet.getVehicule().getId()!=trajetDto.getVehiculeId()))
        	if(!vehicule.isDisponible())
			throw new IllegalStateException("Le véhicule n'est pas disponible.");
        			else
        			{
        			// Rendre l'ancien véhicule disponible
        	        oldVehicule.setDisponible(true);
        	        vehiculeRepository.save(oldVehicule);
        	        // Assigner le nouveau véhicule
        	         existingTrajet.setVehicule(vehicule);
        	         vehicule.setDisponible(false);
        	         vehiculeRepository.save(vehicule);
        			}

     // Mettre à jour les informations du trajet
        existingTrajet.setPointDepart(trajetDto.getPointDepart());
        existingTrajet.setPointArrivee(trajetDto.getPointArrivee());
        existingTrajet.setDateDepart(trajetDto.getDateDepart());
        existingTrajet.setDateArrivee(trajetDto.getDateArrivee());
        Trajet updateTrajetObj= trajetRepository.save(existingTrajet);
		return TrajetMapper.mapToTrajetDto(updateTrajetObj);
        
    }

    @Override
    @Transactional
    public void supprimerTrajet(Long id) {
        Trajet trajet = trajetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trajet non trouvé"));

        Conducteur conducteur = trajet.getConducteur();
        Vehicule vehicule = trajet.getVehicule();

        // Rendre le conducteur et le véhicule disponibles avant de supprimer le trajet
        conducteur.setDisponible(true);
        vehicule.setDisponible(true);
        conducteurRepository.save(conducteur);
        vehiculeRepository.save(vehicule);

        trajetRepository.delete(trajet);
    }
}
