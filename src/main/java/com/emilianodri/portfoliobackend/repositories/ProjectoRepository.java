package com.emilianodri.portfoliobackend.repositories;


import com.emilianodri.portfoliobackend.entities.Projecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectoRepository extends CrudRepository<Projecto, Integer> {



}
