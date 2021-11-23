package eu.codeacademy.spring.facebook.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comments {

    private Long commentId;

    private Long postId;

    private Long userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String commentText;
}
