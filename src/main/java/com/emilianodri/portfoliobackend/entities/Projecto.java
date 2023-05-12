package com.emilianodri.portfoliobackend.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.Date;

@Table(name = "projectos")
@Entity
public class Projecto {
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

    @Lob
    @Column(name = "description", columnDefinition = "text")
    @Getter
    @Setter
    private String description;

    @Lob
    @Column(name = "link", columnDefinition = "text")
    @Getter
    @Setter
    private String link;


    // Getter, setter and toString() methods here...
}
