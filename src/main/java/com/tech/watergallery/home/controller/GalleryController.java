package com.tech.watergallery.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gallery")
public class GalleryController {
    @GetMapping("")
    public String test() {
        return "hello gallery world";
    }

    @GetMapping("/test")
    public String test2() {
        return "hello gallery world";
    }
}
