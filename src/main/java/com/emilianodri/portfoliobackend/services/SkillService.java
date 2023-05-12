package com.emilianodri.portfoliobackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.emilianodri.portfoliobackend.entities.Skill;
import com.emilianodri.portfoliobackend.repositories.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> findAll() {
        List<Skill> skills = new ArrayList<>();
        skillRepository.findAll().forEach(skills::add);

        return skills;
    }

    public Optional<Skill> findById(int id) {
        return skillRepository.findById(id);
    }

    public Skill update(Skill skillToUpdate) {
        return skillRepository.save(skillToUpdate);
    }

    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    public void delete(int id) {
        skillRepository.deleteById(id);
    }


}
