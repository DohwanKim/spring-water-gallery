package com.tech.watergallery.home.repository;

import com.tech.watergallery.home.entity.Gallery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class GalleryRepositoryTest {
    @Autowired
    private GalleryRepository target;

    @Test
    void create() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Gallery gallery = Gallery.builder()
                .description("testDescription")
                .title("testTitle")
                .completed(localDateTime)
                .content("testContent")
                .build();

        target.create(gallery);
    }
}
