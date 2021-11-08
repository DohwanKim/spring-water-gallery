package com.tech.watergallery.home.service;

import com.tech.watergallery.home.controller.GalleryEndpoint.GalleryInfo;
import com.tech.watergallery.home.entity.Gallery;
import com.tech.watergallery.home.repository.GalleryRepository;

import java.util.Optional;

import javax.persistence.EntityManager;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GalleryService {
    private final GalleryRepository galleryRepository;
    private final EntityManager em;

    public int create(GalleryInfo galleryInfo) {
        em.getTransaction().begin();

        Gallery gallery = Gallery.builder().build();

        em.persist(gallery);

        em.getTransaction().commit();

        return galleryRepository.create(Gallery.builder()
                .title(galleryInfo.getTitle())
                .description(galleryInfo.getDescription())
                .content(galleryInfo.getContent())
                .completed(galleryInfo.getCompleted())
                .build());
    }

    public int update(long id, GalleryInfo galleryInfo) {
        return galleryRepository.update(Gallery.builder()
                .id(id)
                .title(galleryInfo.getTitle())
                .description(galleryInfo.getDescription())
                .content(galleryInfo.getContent())
                .completed(galleryInfo.getCompleted())
                .build());
    }

    public Gallery find(long id) {
        return galleryRepository.find(id);
    }

    public List<Gallery> findAll() {
        return galleryRepository.findAll();
    }
}
