package com.emilianodri.portfoliobackend.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.Date;

@Table(name = "skills")
@Entity
public class Skill {
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

    @Column(name = "total", nullable = false)
    @Getter
    @Setter
    private Integer total;

    @Lob
    @Column(name = "description", columnDefinition = "text")
    @Getter
    @Setter
    private String description;


    // Getter, setter and toString() methods here...
}
