package com.emilianodri.portfoliobackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.emilianodri.portfoliobackend.entities.Projecto;
import com.emilianodri.portfoliobackend.repositories.ProjectoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectoService {

    private final ProjectoRepository projectoRepository;

    public ProjectoService(ProjectoRepository projectoRepository) {
        this.projectoRepository = projectoRepository;
    }

    public List<Projecto> findAll() {
        List<Projecto> projectos = new ArrayList<>();
        projectoRepository.findAll().forEach(projectos::add);

        return projectos;
    }

    public Optional<Projecto> findById(int id) {
        return projectoRepository.findById(id);
    }

    public Projecto create(Projecto projecto) {
        return projectoRepository.save(projecto);
    }

    public Projecto update(Projecto projectoToUpdate) {
        return projectoRepository.save(projectoToUpdate);
    }

    public void delete(int id) {
        projectoRepository.deleteById(id);
    }


}
