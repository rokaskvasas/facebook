package eu.codeacademy.spring.facebook.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    private Long postId;

    private Long userId;

    private String postText;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
