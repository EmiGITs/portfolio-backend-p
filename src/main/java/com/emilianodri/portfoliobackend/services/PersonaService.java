package com.emilianodri.portfoliobackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.emilianodri.portfoliobackend.entities.Persona;
import com.emilianodri.portfoliobackend.repositories.PersonaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        List<Persona> personas = new ArrayList<>();
        personaRepository.findAll().forEach(personas::add);

        return personas;
    }

    public Optional<Persona> findById(int id) {
        return personaRepository.findById(id);
    }

    public Persona update(Persona personaToUpdate) {
        return personaRepository.save(personaToUpdate);
    }


}
