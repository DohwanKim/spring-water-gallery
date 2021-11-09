package com.tech.watergallery.home.service;

import com.tech.watergallery.home.controller.GalleryEndpoint.GalleryInfo;
import com.tech.watergallery.home.entity.Gallery;
import com.tech.watergallery.home.repository.GalleryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GalleryServiceTest {
    @InjectMocks
    private GalleryService target;
    @Mock
    private GalleryRepository galleryRepository;

    final static LocalDateTime NOW = LocalDateTime.of(2021, 10, 5, 23, 20);

    @Test
    void create() {
        Gallery gallery = Gallery.builder()
                .title("testTitle")
                .description("testDescription")
                .content("testContent")
                .completed(NOW)
                .build();
        GalleryInfo galleryInfo = GalleryInfo.builder()
                .title("testTitle")
                .description("testDescription")
                .content("testContent")
                .completed(NOW)
                .build();

        when(galleryRepository.save(gallery).getId().intValue()).thenReturn(1);
        assertThat(target.create(galleryInfo)).isEqualTo(1);
        verify(galleryRepository).save(gallery);
    }

    @Test
    void update() {
        long id = 123;
        Gallery gallery = Gallery.builder()
                .id(id)
                .description("testDescription")
                .title("testTitle")
                .content("testContent")
                .completed(NOW)
                .build();
        GalleryInfo galleryInfo = GalleryInfo.builder()
                .description("testDescription")
                .title("testTitle")
                .content("testContent")
                .completed(NOW)
                .build();

        when(galleryRepository.save(gallery).getId().intValue()).thenReturn(1);
        assertThat(target.update(id, galleryInfo)).isEqualTo(1);
        verify(galleryRepository).save(gallery);
    }

    @Test
    void find() {
        long id = 123;
        Gallery gallery = Gallery.builder()
                                 .id(1L)
                                 .title("testTitle")
                                 .description("testDescription")
                                 .content("testContent")
                                 .completed(NOW)
                                 .build();

        when(galleryRepository.findPk(id)).thenReturn(gallery);
        assertThat(target.find(id)).isEqualTo(gallery);
        verify(galleryRepository).findPk(id);
    }
}
