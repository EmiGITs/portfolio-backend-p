package com.emilianodri.portfoliobackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.emilianodri.portfoliobackend.entities.Educacion;
import com.emilianodri.portfoliobackend.repositories.EducacionRepository;
import org.springframework.stereotype.Service;

@Service
public class EducacionService {

    private final EducacionRepository educacionRepository;

    public EducacionService(EducacionRepository educacionRepository) {
        this.educacionRepository = educacionRepository;
    }

    public List<Educacion> findAll() {
        List<Educacion> educaciones = new ArrayList<>();
        educacionRepository.findAll().forEach(educaciones::add);

        return educaciones;
    }

    public Optional<Educacion> findById(int id) {
        return educacionRepository.findById(id);
    }

    public Educacion update(Educacion educacionToUpdate) {
        return educacionRepository.save(educacionToUpdate);
    }

    public Educacion create(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    public void delete(int id) {
        educacionRepository.deleteById(id);
    }


}
