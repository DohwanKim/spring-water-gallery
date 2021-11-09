package com.tech.watergallery.home.repository;

import com.tech.watergallery.home.entity.Gallery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GalleryRepositoryTest {
    @Autowired
    private GalleryRepository target;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void create() {
        Gallery gallery = Gallery.builder()
                .title("testTitle")
                .description("testDescription")
                .content("testContent")
                .img_url("testUrl")
                .completed(LocalDateTime.now())
                .build();

        target.create(gallery);
    }

    @Test
    public void find() {
        Gallery gallery = Gallery.builder()
                .id(123L)
                .title("testTitle")
                .description("testDescription")
                .content("testContent")
                .completed(LocalDateTime.now())
                .build();

        jdbcTemplate.update("INSERT INTO gallery " +
                           "SET id=?, title=?, description=?, content=?, completed=?, updated_at=NOW()",
                            gallery.getId(), gallery.getTitle(), gallery.getDescription(), gallery.getContent(), gallery.getCompleted().toString());

        assertThat(target.find(gallery.getId())).isEqualTo(Optional.of(gallery));
    }

    @Test
    public void update() {
        // test
    }
}
