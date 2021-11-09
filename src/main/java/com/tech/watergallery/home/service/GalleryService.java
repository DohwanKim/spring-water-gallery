package com.tech.watergallery.home.service;

import com.tech.watergallery.home.controller.GalleryEndpoint.GalleryInfo;
import com.tech.watergallery.home.entity.Gallery;
import com.tech.watergallery.home.repository.GalleryRepository;

import javax.persistence.EntityManager;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GalleryService {
    private final GalleryRepository galleryRepository;
    private final EntityManager em;

    @Transactional
    public int create(GalleryInfo galleryInfo) {
        Gallery gallery = Gallery.builder()
                .title(galleryInfo.getTitle())
                .description(galleryInfo.getDescription())
                .content(galleryInfo.getContent())
                .img_url(galleryInfo.getImg_url())
                .completed(galleryInfo.getCompleted())
                .created_at(galleryInfo.getCreated_at())
                .updated_at(galleryInfo.getUpdated_at())
                .build();

        //id가 null이면 insert로 실행됨
        galleryRepository.saveAndFlush(gallery);
        return gallery.getId().intValue();
    }

    public int update(long id, GalleryInfo galleryInfo) {

        Gallery gallery = Gallery.builder()
                .title(galleryInfo.getTitle())
                .description(galleryInfo.getDescription())
                .content(galleryInfo.getContent())
                .img_url(galleryInfo.getImg_url())
                .completed(galleryInfo.getCompleted())
                .created_at(galleryInfo.getCreated_at())
                .updated_at(galleryInfo.getUpdated_at())
                .build();

        //id가 null이 아니면 update로 실행됨
        galleryRepository.saveAndFlush(gallery);
        return gallery.getId().intValue();
    }

    public Gallery find(long id) {
        return galleryRepository.findPk(id);
    }

    public List<Gallery> findAll() {
        return galleryRepository.findAll();
    }
}
