package com.akram.spring.tms.mapper;
import com.akram.spring.tms.dto.ConducteurDto;
import com.akram.spring.tms.entity.Conducteur;
public class ConducteurMapper {
	
	public static ConducteurDto mapToConducteurDto(Conducteur conducteur) {
		return new ConducteurDto(
				conducteur.getId(),
				conducteur.getNom(),
				conducteur.getPrenom(),
				conducteur.getPermis(),
				conducteur.getTelephone(),
				conducteur.isDisponible());
	}
	
	public static Conducteur mapToConducteur(ConducteurDto conducteurDto) {
		return new Conducteur(
				conducteurDto.getId(),
				conducteurDto.getNom(),
				conducteurDto.getPrenom(),
				conducteurDto.getPermis(),
				conducteurDto.getTelephone(),
				conducteurDto.isDisponible());
	}

}
