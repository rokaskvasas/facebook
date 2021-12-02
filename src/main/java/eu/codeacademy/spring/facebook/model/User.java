package eu.codeacademy.spring.facebook.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private LocalDateTime registeredAt;

}
