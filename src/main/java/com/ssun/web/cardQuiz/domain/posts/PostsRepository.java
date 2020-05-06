package com.ssun.web.cardQuiz.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//<entity 클래스, PK 타입>
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
