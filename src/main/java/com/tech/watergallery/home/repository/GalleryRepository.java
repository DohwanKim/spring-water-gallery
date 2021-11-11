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

    // save가 동작할때 created_at, updated_at  default 로 NOW() 가 동작하길 원함
    // 이 서버의 시간이 아니라 db서버의 현제 시간을 사용하고 싶음
    
    // ㄴ 답변: mysql db default 값에다가 CURRENT_TIMESTAMP 넣으면 댐.
}
