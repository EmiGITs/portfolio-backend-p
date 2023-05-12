package com.emilianodri.portfoliobackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.emilianodri.portfoliobackend.entities.Experiencia;
import com.emilianodri.portfoliobackend.repositories.ExperienciaRepository;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {

    private final ExperienciaRepository experienciaRepository;

    public ExperienciaService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

    public List<Experiencia> findAll() {
        List<Experiencia> experiencias = new ArrayList<>();
        experienciaRepository.findAll().forEach(experiencias::add);

        return experiencias;
    }

    public Optional<Experiencia> findById(int id) {
        return experienciaRepository.findById(id);
    }

    public Experiencia update(Experiencia experienciaToUpdate) {
        return experienciaRepository.save(experienciaToUpdate);
    }

    public Experiencia create(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public void delete(int id) {
        experienciaRepository.deleteById(id);
    }

}
