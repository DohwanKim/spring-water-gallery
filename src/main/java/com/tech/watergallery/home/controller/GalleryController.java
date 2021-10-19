package com.tech.watergallery.home.controller;

import com.tech.watergallery.home.service.GalleryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/gallery")
public class GalleryController {
    private final GalleryService galleryService;

}
