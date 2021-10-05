package com.tech.watergallery.home.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Builder
@Data
public class Gallery {
    private Long id;
    @NonNull
    private String title;
    private String description;
    private String content;
    private LocalDateTime completed;
}
