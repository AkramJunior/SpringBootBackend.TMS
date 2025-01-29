package com.akram.spring.tms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akram.spring.tms.entity.Conducteur;

@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
}
