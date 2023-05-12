package com.emilianodri.portfoliobackend.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.Date;

@Table(name = "experiencia_laboral")
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "title",unique = false, length = 255, nullable = false)
    @Getter
    @Setter
    private String title;

    @Column(name = "subtitle",unique = false, length = 255, nullable = false)
    @Getter
    @Setter
    private String subtitle;

    @Column(name = "startdate",unique = false, nullable = false)
    @Getter
    @Setter
    private Date startdate;

    @Column(name = "enddate",unique = false)
    @Getter
    @Setter
    private Date enddate;

    @Column(name = "location",unique = false, length = 255, nullable = false)
    @Getter
    @Setter
    private String location;


    // Getter, setter and toString() methods here...
}
