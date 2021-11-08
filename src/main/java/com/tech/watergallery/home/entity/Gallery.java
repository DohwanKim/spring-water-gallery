package com.tech.watergallery.home.entity;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="gallery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gallery {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="title", nullable=false, length=100)
    private String title;

    @Column(name="description", nullable=false, length=100)
    private String description;

    @Column(name="content", nullable=false, length=100)
    private String content;

    @Column(name="completed")
    private LocalDateTime completed;
}
