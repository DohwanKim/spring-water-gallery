package com.tech.watergallery.home.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Gallery {
    private Long id;
    @NonNull
    private String title;
    private String description;
    private String content;
    private LocalDateTime completed;
}
