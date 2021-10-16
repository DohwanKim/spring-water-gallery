package com.tech.watergallery.home.service;

import com.tech.watergallery.home.entity.Gallery;
import com.tech.watergallery.home.repository.GalleryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GalleryService {
    private final GalleryRepository galleryRepository;

    public int create(Gallery gallery) {
        return galleryRepository.create(gallery);
    }

    public int update() {
        return galleryRepository.update();
    }

    public Gallery find(long id) throws IllegalAccessException {
        return galleryRepository.find(id)
                                .orElseThrow(() -> new IllegalAccessException("resource is not exist"));
    }
}
