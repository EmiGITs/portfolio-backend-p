package com.emilianodri.portfoliobackend.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.Date;

@Table(name = "persona")
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "title",unique = false, length = 60, nullable = false)
    @Getter
    @Setter
    private String title;

    @Column(name = "subtitle",unique = false, length = 255, nullable = false)
    @Getter
    @Setter
    private String subtitle;

    @Column(name = "location",unique = false, length = 255, nullable = false)
    @Getter
    @Setter
    private String location;

    @Column(name = "insignia",unique = false, length = 100, nullable = false)
    @Getter
    @Setter
    private String insignia;

    @Lob
    @Column(name = "about", columnDefinition = "text")
    @Getter
    @Setter
    private String about;


    // Getter, setter and toString() methods here...
}
