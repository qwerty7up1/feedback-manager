package com.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Getter
    @Setter
    private String text;

    @Column(name = "publication_time")
    @Getter
    @Setter
    private LocalDateTime publicationTime;

    @Setter
    @ManyToOne
    private User user;

}
