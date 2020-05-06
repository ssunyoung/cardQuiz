package com.ssun.cardquiz.springboot.service.posts;
// Controller와 Repository(DAO)의 중간 역할 , @Transactional 사용 영역

import com.ssun.cardquiz.springboot.domain.posts.Posts;
import com.ssun.cardquiz.springboot.domain.posts.PostsRepository;
import com.ssun.cardquiz.springboot.web.dto.PostsResponseDto;
import com.ssun.cardquiz.springboot.web.dto.PostsSaveRequestDto;
import com.ssun.cardquiz.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
