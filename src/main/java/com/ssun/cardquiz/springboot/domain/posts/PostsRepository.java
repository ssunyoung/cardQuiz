package com.ssun.cardquiz.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//Posts.java 클래스로 Database에 접근하게 해 줄 JpaRepository
//<entity 클래스, PK 타입>
public interface PostsRepository extends JpaRepository<Posts,Long> {

    //crud 메서드 자동생성
}
