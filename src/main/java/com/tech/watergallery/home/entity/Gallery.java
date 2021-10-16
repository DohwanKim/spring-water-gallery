package com.tech.watergallery.home.entity;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gallery {
    private Long id;
    @NonNull
    private String title;
    private String description;
    private String content;
    private LocalDateTime completed;
}
