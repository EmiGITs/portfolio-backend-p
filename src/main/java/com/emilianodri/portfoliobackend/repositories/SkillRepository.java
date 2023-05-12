package com.emilianodri.portfoliobackend.repositories;

import com.emilianodri.portfoliobackend.entities.Persona;
import com.emilianodri.portfoliobackend.entities.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {



}
