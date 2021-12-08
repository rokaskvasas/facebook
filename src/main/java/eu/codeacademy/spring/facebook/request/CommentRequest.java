package eu.codeacademy.spring.facebook.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private String commentText;

    private String returnPath;


}
