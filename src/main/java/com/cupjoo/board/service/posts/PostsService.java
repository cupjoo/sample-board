package com.cupjoo.board.service.posts;

import com.cupjoo.board.domain.posts.PostsRepository;
import com.cupjoo.board.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor    // final 선언된 모든 필드의 생성자 생성
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
