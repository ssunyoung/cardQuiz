package com.ssun.cardquiz.springboot.web.dto;
// 계층간 데이터 교환을 위한 객체
// 요청한 데이터를 받을 dto
// 글 작성 위한 Data Transfer Object

import com.ssun.cardquiz.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
