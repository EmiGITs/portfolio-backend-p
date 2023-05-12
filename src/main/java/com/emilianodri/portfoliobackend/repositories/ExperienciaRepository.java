package com.emilianodri.portfoliobackend.repositories;

import com.emilianodri.portfoliobackend.entities.Experiencia;
import com.emilianodri.portfoliobackend.entities.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends CrudRepository<Experiencia, Integer> {



}
