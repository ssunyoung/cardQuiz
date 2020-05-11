package com.ssun.cardquiz.springboot.domain.posts;
//crud 메서드 자동생성

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Posts.java 클래스로 Database에 접근하게 해 줄 JpaRepository
//<entity 클래스, PK 타입>
public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
