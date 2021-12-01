package eu.codeacademy.spring.facebook.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private Long userId;

    private Integer roleId;
  
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private LocalDateTime registeredAt;
}
