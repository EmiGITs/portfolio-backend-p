package com.emilianodri.portfoliobackend.controllers;

import com.emilianodri.portfoliobackend.entities.Skill;
import com.emilianodri.portfoliobackend.repositories.SkillRepository;
import com.emilianodri.portfoliobackend.requests.CreateSkillInput;
import com.emilianodri.portfoliobackend.requests.UpdateSkillInput;
import com.emilianodri.portfoliobackend.services.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SkillController {
    public SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }


    @GetMapping("/api/skills")
    public ResponseEntity<List<Skill>> allSkills() {
        List<Skill> skills = skillService.findAll();


        return new ResponseEntity<>(skills, HttpStatus.OK);
    }




    @PatchMapping("/api/skills/{id}/update")
    public ResponseEntity<Skill> updateSkill(@PathVariable int id, @RequestBody UpdateSkillInput updateSkillInput) {
        Optional<Skill> optionalSkill = skillService.findById(id);

        if (optionalSkill.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Skill skillToUpdate = optionalSkill.get();

        skillToUpdate.setTitle(updateSkillInput.title());

        skillToUpdate.setTotal(updateSkillInput.total());

        skillToUpdate.setDescription(updateSkillInput.description());

        Skill skillUpdated = skillService.update(skillToUpdate);



        return new ResponseEntity<>(skillUpdated, HttpStatus.OK);
    }

    @PostMapping("/api/skills/create")
    public ResponseEntity<Skill> createSkill(@RequestBody CreateSkillInput createSkillInput) {
        Skill skillCreated = skillService.create(createSkillInput.toSkill());

        return new ResponseEntity<>(skillCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/skills/{id}/delete")
    public ResponseEntity<Void> deleteSkill(@PathVariable int id) {
        skillService.delete(id);

        return ResponseEntity.noContent().build();
    }



}
