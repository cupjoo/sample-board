package com.cupjoo.board.config.auth.dto;

import com.cupjoo.board.domain.user.User;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    // 직렬화를 위해 인증에 필요한 사용자 정보만 포함
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
