package com.emilianodri.portfoliobackend.requests;



import com.emilianodri.portfoliobackend.entities.Projecto;


public record CreateProjectoInput(String title, String description, String link) {
    public Projecto toProjecto() {
        Projecto projecto = new Projecto();

        projecto.setTitle(title);
        projecto.setDescription(description);
        projecto.setLink(link);


        return projecto;
    }
}
