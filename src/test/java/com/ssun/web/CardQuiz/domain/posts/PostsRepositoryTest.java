package com.ssun.web.CardQuiz.domain.posts;

import com.ssun.web.cardQuiz.domain.posts.Posts;
import com.ssun.web.cardQuiz.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After //단위테스트가 끝날 때마다 수행되는 메소드를 지정
    // 배포 전 전체 테스트를 수행할 떄 테스트 간 데이터 침범을 막기 위해서 사용
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        //postsRepository.save - > 테이블 posts에 insert/update쿼리를 실행합니다.
        //id값이 있다면 update 없다면 insert 실행
        postsRepository.save(Posts.builder().title(title).content(content).author("lalala819@naver.com").build());

        //when
        //postsRepository.findAll -> 테이블 posts에 있는 모든 데이터를 조회해오는 메소드
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }


}
