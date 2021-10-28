package com.tech.watergallery.home.controller;

import com.tech.watergallery.home.entity.Gallery;
import com.tech.watergallery.home.service.GalleryService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/gallery")
public class GalleryController implements GalleryEndpoint {
    private final GalleryService galleryService;

    @Override
    @GetMapping("")
    public ResponseEntity<List<Gallery>> findAll() {
        return ResponseEntity.ok(galleryService.findAll());
    }

    @Override
    @PostMapping("")
    public ResponseEntity<Void> create(@RequestBody GalleryInfo galleryInfo) {
        galleryService.create(galleryInfo);

        return ResponseEntity.ok(null);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Gallery> find(@PathVariable("id") long id) throws IllegalAccessException {
        Gallery gallery = galleryService.find(id)
                .orElseThrow(() -> new IllegalAccessException("resource is not exist"));

        return ResponseEntity.ok(gallery);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id,
                                       @RequestBody GalleryInfo galleryInfo) {
        galleryService.update(id, galleryInfo);

        return ResponseEntity.ok(null);
    }
}
