package com.emilianodri.portfoliobackend.controllers;

import com.emilianodri.portfoliobackend.entities.Educacion;
import com.emilianodri.portfoliobackend.repositories.EducacionRepository;
import com.emilianodri.portfoliobackend.requests.CreateEducacionInput;
import com.emilianodri.portfoliobackend.requests.UpdateEducacionInput;
import com.emilianodri.portfoliobackend.services.EducacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EducacionController {
    public EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }


    @GetMapping("/api/educaciones")
    public ResponseEntity<List<Educacion>> allEducacions() {
        List<Educacion> educacions = educacionService.findAll();


        return new ResponseEntity<>(educacions, HttpStatus.OK);
    }




    @PatchMapping("/api/educaciones/{id}/update")
    public ResponseEntity<Educacion> updateEducacion(@PathVariable int id, @RequestBody UpdateEducacionInput updateEducacionInput) {
        Optional<Educacion> optionalEducacion = educacionService.findById(id);

        if (optionalEducacion.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Educacion educacionToUpdate = optionalEducacion.get();

        educacionToUpdate.setTitle(updateEducacionInput.title());

        educacionToUpdate.setSubtitle(updateEducacionInput.subtitle());

        educacionToUpdate.setStartdate(updateEducacionInput.startdate());

        educacionToUpdate.setEnddate(updateEducacionInput.enddate());

        Educacion educacionUpdated = educacionService.update(educacionToUpdate);



        return new ResponseEntity<>(educacionUpdated, HttpStatus.OK);
    }

    @PostMapping("/api/educaciones/create")
    public ResponseEntity<Educacion> createEducacion(@RequestBody CreateEducacionInput createEducacionInput) {
        Educacion educacionCreated = educacionService.create(createEducacionInput.toEducacion());

        return new ResponseEntity<>(educacionCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/educaciones/{id}/delete")
    public ResponseEntity<Void> deleteEducacion(@PathVariable int id) {
        educacionService.delete(id);

        return ResponseEntity.noContent().build();
    }





}
