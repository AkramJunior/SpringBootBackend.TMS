package com.akram.spring.tms.repository;

import com.akram.spring.tms.entity.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Long> {
}
