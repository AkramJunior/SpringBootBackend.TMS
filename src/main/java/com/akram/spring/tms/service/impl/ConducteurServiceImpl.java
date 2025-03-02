package com.akram.spring.tms.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.akram.spring.tms.dto.ConducteurDto;
import com.akram.spring.tms.entity.Conducteur;
import com.akram.spring.tms.exception.ResourceNotFoundException;
import com.akram.spring.tms.mapper.ConducteurMapper;
import com.akram.spring.tms.repository.ConducteurRepository;
import com.akram.spring.tms.service.ConducteurService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConducteurServiceImpl implements ConducteurService {
	
	private ConducteurRepository conducteurRepository;
	
	@Override
	public ConducteurDto addConducteur(ConducteurDto conducteurDto) {
		
		Conducteur conducteur= ConducteurMapper.mapToConducteur(conducteurDto);
		Conducteur saveConducteur= conducteurRepository.save(conducteur);
	
		return ConducteurMapper.mapToConducteurDto(saveConducteur);
	}

	@Override
	public ConducteurDto getConducteurById(Long conducteurId) {
	Conducteur conducteur= conducteurRepository.findById(conducteurId).orElseThrow(() -> new ResourceNotFoundException("Conducteur avec id"+conducteurId+"ne existe pas"));
		
		return ConducteurMapper.mapToConducteurDto(conducteur);
	}

	@Override
	public List<ConducteurDto> getAllConductures() {
			List <Conducteur>  conducteurs=conducteurRepository.findAll();	
			return conducteurs.stream().map((conducteur) -> ConducteurMapper.mapToConducteurDto(conducteur)).collect(Collectors.toList());
	}

	@Override
	public ConducteurDto updateConducteur(Long conducteurId, ConducteurDto updatedConducteur) {
		Conducteur conducteur= conducteurRepository.findById(conducteurId).orElseThrow(()->new ResourceNotFoundException("Conducteur avec id"+conducteurId+"ne existe pas"));
		conducteur.setNom(updatedConducteur.getNom());
		conducteur.setPrenom(updatedConducteur.getPrenom());
		conducteur.setPermis(updatedConducteur.getPermis());
		conducteur.setTelephone(updatedConducteur.getTelephone());
		Conducteur updateConducteurObj= conducteurRepository.save(conducteur);
		return ConducteurMapper.mapToConducteurDto(updateConducteurObj);
	}

	@Override
	public void deleteConducteur(Long conducteurId) {
		Conducteur conducteur= conducteurRepository.findById(conducteurId).orElseThrow(()->new ResourceNotFoundException("Conducteur avec id"+conducteurId+"ne existe pas"));
		conducteurRepository.deleteById(conducteurId);
	}

}




