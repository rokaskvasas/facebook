package eu.codeacademy.spring.facebook.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequest {

    private Long commentId;

    private Long postId;

    private Long userId;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    private String commentText;


}
