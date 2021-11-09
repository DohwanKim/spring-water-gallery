package com.tech.watergallery.home.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="gallery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gallery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title", nullable=false, length=100)
    private String title;

    @Column(name="description", nullable=false, length=256)
    private String description;

    @Column(name="content", nullable=false, length=256)
    private String content;

    @Column(name="img_url", nullable=false, length=256)
    // 변수 이름 같을 필요 없음
    private String image;

    @Column(name="completed")
    private LocalDateTime completed;

    @Column(name="created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name="updated_at", nullable = false)
    private LocalDateTime updated_at;
}
