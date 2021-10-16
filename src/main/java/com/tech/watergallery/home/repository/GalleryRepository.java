package com.tech.watergallery.home.repository;

import com.tech.watergallery.home.entity.Gallery;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface GalleryRepository {
    int create(Gallery gallery);
    int update();
    Optional<Gallery> find(long id);
}
