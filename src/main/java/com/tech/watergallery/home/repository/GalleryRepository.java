package com.tech.watergallery.home.repository;

import com.tech.watergallery.home.entity.Gallery;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    //@Query("SELECT g.id FROM Gallery g WHERE g.id = :id")
    @Query(value = "SELECT * FROM gallery WHERE id = :id", nativeQuery = true)
    Gallery findPk(@Param("id") long id);
    //Optional<Gallery> findById(Long id);
}
