package com.ssun.cardquiz.springboot.web.dto;

import com.ssun.cardquiz.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    // entity 필드 중 일부를 사용하므로
    //굳이 모든 필드를 가진 생성자가 필요하진 않으므로 entity를 받아 처리
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
