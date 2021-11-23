package eu.codeacademy.spring.facebook.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    private Long userId;

    private Integer roleId;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private LocalDateTime registeredAt;
}
