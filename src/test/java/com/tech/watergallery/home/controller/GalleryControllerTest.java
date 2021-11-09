package com.tech.watergallery.home.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.watergallery.home.controller.GalleryEndpoint.GalleryInfo;
import com.tech.watergallery.home.entity.Gallery;
import com.tech.watergallery.home.service.GalleryService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void create() throws Exception {
        GalleryInfo galleryInfo = GalleryInfo.builder()
                .title("testTitle")
                .description("testDescription")
                .content("testContent")
                .img_url("test_url")
                .completed(NOW)
                .created_at(NOW)
                .updated_at(NOW)
                .build();

        when(galleryService.create(galleryInfo)).thenReturn(1);
        mockMvc.perform(post("/gallery")
                        .content(objectMapper.writeValueAsString(galleryInfo))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        verify(galleryService).create(galleryInfo);
    }

    @Test
    public void find() throws Exception {
        long id = 123;
        Gallery gallery = createGallery(id);

        when(galleryService.find(id)).thenReturn(gallery);
        mockMvc.perform(get("/gallery/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(gallery)));
        verify(galleryService).find(id);
    }

    @Test
    public void find__resourceNotFound() {
        long id = 123;

        when(galleryService.find(id)).thenReturn(null);
        assertThatThrownBy(() -> mockMvc.perform(get("/gallery/" + id))
                                                    .andExpect(status().is5xxServerError()))
                .hasCause(new IllegalAccessException("resource is not exist"));
        verify(galleryService).find(id);
    }

    @Test
    public void update() throws Exception {
        long id = 123;
        GalleryInfo galleryInfo = GalleryInfo.builder()
                .title("testTitle")
                .description("testDescription")
                .content("testContent")
                .img_url("test_url")
                .completed(NOW)
                .created_at(NOW)
                .updated_at(NOW)
                .build();

        when(galleryService.update(id, galleryInfo)).thenReturn(1);
        mockMvc.perform(put("/gallery/" + id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(galleryInfo)))
                .andExpect(status().isOk());
        verify(galleryService).update(id, galleryInfo);
    }

    private Gallery createGallery(long id) {
        return Gallery.builder()
                .id(id)
                .title("testTitle")
                .description("testDescription")
                .content("testContent")
                .img_url("test_url")
                .completed(NOW)
                .created_at(NOW)
                .updated_at(NOW)
                .build();
    }
}
