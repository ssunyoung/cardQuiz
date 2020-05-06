package com.ssun.cardquiz.springboot.web;
// api 요청을 받을 controller

import com.ssun.cardquiz.springboot.service.posts.PostsService;
import com.ssun.cardquiz.springboot.web.dto.PostsResponseDto;
import com.ssun.cardquiz.springboot.web.dto.PostsSaveRequestDto;
import com.ssun.cardquiz.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    //글 작성
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
    //글 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    //?
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

}
