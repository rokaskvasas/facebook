package eu.codeacademy.spring.facebook.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Post {

    private Long postId;

    private Long userId;

    private String postText;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
