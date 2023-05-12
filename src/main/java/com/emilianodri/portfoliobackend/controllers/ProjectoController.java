package com.emilianodri.portfoliobackend.controllers;

import com.emilianodri.portfoliobackend.entities.Projecto;
import com.emilianodri.portfoliobackend.repositories.ProjectoRepository;
import com.emilianodri.portfoliobackend.requests.CreateProjectoInput;
import com.emilianodri.portfoliobackend.requests.UpdateProjectoInput;
import com.emilianodri.portfoliobackend.services.ProjectoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectoController {
    public ProjectoService projectoService;

    public ProjectoController(ProjectoService projectoService) {
        this.projectoService = projectoService;
    }


    @GetMapping("/api/projectos")
    public ResponseEntity<List<Projecto>> allProjectos() {
        List<Projecto> projectos = projectoService.findAll();


        return new ResponseEntity<>(projectos, HttpStatus.OK);
    }




    @PatchMapping("/api/projectos/{id}/update")
    public ResponseEntity<Projecto> updateProjecto(@PathVariable int id, @RequestBody UpdateProjectoInput updateProjectoInput) {
        Optional<Projecto> optionalProjecto = projectoService.findById(id);

        if (optionalProjecto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Projecto projectoToUpdate = optionalProjecto.get();

        projectoToUpdate.setTitle(updateProjectoInput.title());

        projectoToUpdate.setDescription(updateProjectoInput.description());

        projectoToUpdate.setLink(updateProjectoInput.link());

        Projecto projectoUpdated = projectoService.update(projectoToUpdate);



        return new ResponseEntity<>(projectoUpdated, HttpStatus.OK);
    }

    @PostMapping("/api/projectos/create")
    public ResponseEntity<Projecto> createProjecto(@RequestBody CreateProjectoInput createProjectoInput) {
        Projecto projectoCreated = projectoService.create(createProjectoInput.toProjecto());

        return new ResponseEntity<>(projectoCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/projectos/{id}/delete")
    public ResponseEntity<Void> deleteProjecto(@PathVariable int id) {
        projectoService.delete(id);

        return ResponseEntity.noContent().build();
    }



}
