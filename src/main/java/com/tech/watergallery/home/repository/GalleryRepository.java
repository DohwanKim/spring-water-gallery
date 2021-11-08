package com.tech.watergallery.home.repository;

import com.tech.watergallery.home.entity.Gallery;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    int create(Gallery gallery);

    int update(Gallery gallery);

    @Query("SELECT * FROM gallery WHERE id = :id")
    Gallery find(@Param("id") long id);
}
