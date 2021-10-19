package com.tech.watergallery.home.controller;

import com.tech.watergallery.home.entity.Gallery;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface GalleryEndpoint {
    ResponseEntity<Void> create(GalleryInfo galleryInfo);
    ResponseEntity<Void> update(long id, GalleryInfo galleryInfo);
    ResponseEntity<Gallery> find(long id) throws IllegalAccessException;
    ResponseEntity<List<Gallery>> findAll();

    @Data
    static class GalleryInfo {
        String title;
        String description;
        String content;
        LocalDateTime completed;
    }
}
