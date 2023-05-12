package com.emilianodri.portfoliobackend.requests;



import com.emilianodri.portfoliobackend.entities.Experiencia;

import java.util.Date;


public record CreateExperienciaInput(String title, String subtitle, String location, Date startdate, Date enddate) {
    public Experiencia toExperiencia() {
        Experiencia experiencia = new Experiencia();

        experiencia.setTitle(title);
        experiencia.setSubtitle(subtitle);
        experiencia.setStartdate(startdate);
        experiencia.setEnddate(enddate);
        experiencia.setLocation(location);


        return experiencia;
    }
}
