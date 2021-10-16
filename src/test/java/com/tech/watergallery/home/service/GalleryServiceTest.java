package com.tech.watergallery.home.service;

import com.tech.watergallery.home.entity.Gallery;
import com.tech.watergallery.home.repository.GalleryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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
                .description("testDescription")
                .title("testTitle")
                .completed(LocalDateTime.now())
                .content("testContent")
                .build();
        when(galleryRepository.create(gallery)).thenReturn(1);
        assertThat(target.create(gallery)).isEqualTo(1);
        verify(galleryRepository).create(gallery);
    }

    @Test
    void update() {
        when(galleryRepository.update()).thenReturn(1);
        assertThat(target.update()).isEqualTo(1);
        verify(galleryRepository).update();
    }

    @Test
    void find() throws IllegalAccessException {
        long id = 123;
        Gallery gallery = Gallery.builder()
                                 .id(1L)
                                 .title("testTitle")
                                 .description("testDescription")
                                 .content("testContent")
                                 .completed(NOW)
                                 .build();

        when(galleryRepository.find(id)).thenReturn(Optional.of(gallery));
        assertThat(target.find(id)).isIn(gallery);
        verify(galleryRepository).find(id);
    }

    @Test
    void find__resourceNotFound() {
        long id = 123;

        when(galleryRepository.find(id)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> target.find(id)).isInstanceOf(IllegalAccessException.class);
        verify(galleryRepository).find(id);
    }
}
