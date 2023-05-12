package com.emilianodri.portfoliobackend.controllers;

import com.emilianodri.portfoliobackend.entities.Persona;
import com.emilianodri.portfoliobackend.repositories.PersonaRepository;
import com.emilianodri.portfoliobackend.requests.UpdatePersonaInput;
import com.emilianodri.portfoliobackend.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
public class PersonaController {
    public PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping("/api/personas")
    public ResponseEntity<List<Persona>> allPersonas() {
        List<Persona> personas = personaService.findAll();


        return new ResponseEntity<>(personas, HttpStatus.OK);
    }




    @PatchMapping("/api/personas/{id}/update")
    public ResponseEntity<Persona> updatePersona(@PathVariable int id, @RequestBody UpdatePersonaInput updatePersonaInput) {
        Optional<Persona> optionalPersona = personaService.findById(id);

        if (optionalPersona.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Persona personaToUpdate = optionalPersona.get();

        personaToUpdate.setTitle(updatePersonaInput.title());

        personaToUpdate.setSubtitle(updatePersonaInput.subtitle());

        personaToUpdate.setLocation(updatePersonaInput.location());

        personaToUpdate.setAbout(updatePersonaInput.about());

        Persona personaUpdated = personaService.update(personaToUpdate);



        return new ResponseEntity<>(personaUpdated, HttpStatus.OK);
    }



}
