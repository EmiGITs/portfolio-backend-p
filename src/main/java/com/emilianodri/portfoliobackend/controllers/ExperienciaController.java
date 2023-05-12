package com.emilianodri.portfoliobackend.controllers;

import com.emilianodri.portfoliobackend.entities.Experiencia;
import com.emilianodri.portfoliobackend.repositories.ExperienciaRepository;
import com.emilianodri.portfoliobackend.requests.CreateExperienciaInput;
import com.emilianodri.portfoliobackend.requests.UpdateExperienciaInput;
import com.emilianodri.portfoliobackend.services.ExperienciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExperienciaController {
    public ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }


    @GetMapping("/api/experiencias")
    public ResponseEntity<List<Experiencia>> allExperiencias() {
        List<Experiencia> experiencias = experienciaService.findAll();


        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }




    @PatchMapping("/api/experiencias/{id}/update")
    public ResponseEntity<Experiencia> updateExperiencia(@PathVariable int id, @RequestBody UpdateExperienciaInput updateExperienciaInput) {
        Optional<Experiencia> optionalExperiencia = experienciaService.findById(id);

        if (optionalExperiencia.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Experiencia experienciaToUpdate = optionalExperiencia.get();

        experienciaToUpdate.setTitle(updateExperienciaInput.title());

        experienciaToUpdate.setSubtitle(updateExperienciaInput.subtitle());

        experienciaToUpdate.setLocation(updateExperienciaInput.location());

        experienciaToUpdate.setStartdate(updateExperienciaInput.startdate());

        experienciaToUpdate.setEnddate(updateExperienciaInput.enddate());

        Experiencia experienciaUpdated = experienciaService.update(experienciaToUpdate);



        return new ResponseEntity<>(experienciaUpdated, HttpStatus.OK);
    }

    @PostMapping("/api/experiencias/create")
    public ResponseEntity<Experiencia> createExperiencia(@RequestBody CreateExperienciaInput createExperienciaInput) {
        Experiencia experienciaCreated = experienciaService.create(createExperienciaInput.toExperiencia());

        return new ResponseEntity<>(experienciaCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/experiencias/{id}/delete")
    public ResponseEntity<Void> deleteExperiencia(@PathVariable int id) {
        experienciaService.delete(id);

        return ResponseEntity.noContent().build();
    }




}
