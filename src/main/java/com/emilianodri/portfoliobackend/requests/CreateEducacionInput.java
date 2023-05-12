package com.emilianodri.portfoliobackend.requests;



import com.emilianodri.portfoliobackend.entities.Educacion;

import java.util.Date;


public record CreateEducacionInput(String title, String subtitle, Date startdate, Date enddate) {
    public Educacion toEducacion() {
        Educacion educacion = new Educacion();

        educacion.setTitle(title);
        educacion.setSubtitle(subtitle);
        educacion.setStartdate(startdate);
        educacion.setEnddate(enddate);


        return educacion;
    }
}
