package com.cupjoo.board.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest     // auto implement H2 DB
public class PostsRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void save_and_load_post(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // insert if not exist, or update
        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("cupjoo@naver.com")
                .build());

        List<Posts> postsList = postRepository.findAll();
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
