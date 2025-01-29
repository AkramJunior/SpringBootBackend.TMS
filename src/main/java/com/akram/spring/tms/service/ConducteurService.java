package com.akram.spring.tms.service;

import java.util.List;

import com.akram.spring.tms.dto.ConducteurDto;


public interface ConducteurService {
	
	ConducteurDto addConducteur(ConducteurDto conducteurDto);
	
	ConducteurDto getConducteurById(Long conducteurId);
	
	List<ConducteurDto> getAllConductures();
	
	ConducteurDto updateConducteur(Long conducteurId, ConducteurDto updatedConducteur);
	
	void deleteConducteur(Long conducteurId);
	
	
	
	
}