package com.emilianodri.portfoliobackend.requests;



import com.emilianodri.portfoliobackend.entities.Skill;

import java.util.Date;


public record CreateSkillInput(String title, String description, Integer total) {
    public Skill toSkill() {
        Skill skill = new Skill();

        skill.setTitle(title);
        skill.setDescription(description);
        skill.setTotal(total);


        return skill;
    }
}
