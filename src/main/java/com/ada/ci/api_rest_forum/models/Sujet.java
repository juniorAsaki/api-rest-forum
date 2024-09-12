package com.ada.ci.api_rest_forum.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Setter
@Table(name = "sujet")
public class Sujet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSujet;

    @Column(name = "title")
    private String title;

    @ManyToOne
    private Forum forum;

//    @OneToMany
//    private List<Message> message;

    @Column(unique = true)
    private String slug;
}
