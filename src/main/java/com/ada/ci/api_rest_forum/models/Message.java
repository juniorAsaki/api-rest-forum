package com.ada.ci.api_rest_forum.models;


import com.ada.ci.api_rest_forum.services.dto.SujetDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;

    @Column(name = "content")
    private String content;

    @Column(name = "createdDate")
    private Instant createdDate;

    @ManyToOne
    private Sujet sujet;

    @Column(unique = true)
    private String slug;
}
