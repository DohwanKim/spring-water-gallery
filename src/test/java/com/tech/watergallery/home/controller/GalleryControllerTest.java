package com.tech.watergallery.home.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.watergallery.home.entity.Gallery;
import com.tech.watergallery.home.service.GalleryService;

import java.time.LocalDateTime;

import java.util.List;

import java.util.Optional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class GalleryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GalleryService galleryService;
    @Autowired
    private ObjectMapper objectMapper;

    final static LocalDateTime NOW = LocalDateTime.of(2021, 10, 5, 23, 20);

    @Test
    public void findAll() throws Exception {
        List<Gallery> galleryLists = Lists.list(createGallery(1),
                createGallery(2),
                createGallery(3));

        when(galleryService.findAll()).thenReturn(galleryLists);
        mockMvc.perform(get("/gallery"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(galleryLists)));
        verify(galleryService).findAll();
    }

    @Test
    public void find() throws Exception {
        long id = 123;
        Gallery gallery = createGallery(id);

        when(galleryService.find(id)).thenReturn(Optional.of(gallery));
        mockMvc.perform(get("/gallery/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(gallery)));
        verify(galleryService).find(id);
    }

    @Test
    public void find__resourceNotFound() {
        long id = 123;

        when(galleryService.find(id)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> mockMvc.perform(get("/gallery/" + id))
                                                    .andExpect(status().is5xxServerError()))
                .hasCause(new IllegalAccessException("resource is not exist"));
        verify(galleryService).find(id);
    }

    private Gallery createGallery(long id) {
        return Gallery.builder()
                .id(id)
                .title("testTitle")
                .description("testDescription")
                .content("testContent")
                .completed(NOW)
                .build();
    }
}
