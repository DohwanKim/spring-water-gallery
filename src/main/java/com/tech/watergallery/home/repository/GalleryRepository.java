package com.tech.watergallery.home.repository;

import com.tech.watergallery.home.entity.Gallery;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface GalleryRepository {
    public int create();
    public int update();
    public Optional<Gallery> find(long id);
}
