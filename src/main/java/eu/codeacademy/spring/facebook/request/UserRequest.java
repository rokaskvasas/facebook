package eu.codeacademy.spring.facebook.request;

import com.sun.istack.NotNull;
import eu.codeacademy.spring.facebook.validation.ValidEmail;
import eu.codeacademy.spring.facebook.validation.ValidUsername;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private Long userId;

    @NotBlank
    @Size(min = 1, max = 15)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 15)
    private String lastName;

    @NotBlank
    @ValidUsername
    @Size(min = 1, max = 20)
    private String username;

    @NotBlank
    @Size(min = 4, max = 20)
    private String password;

    @NotBlank
    @ValidEmail
    private String email;

    private LocalDateTime registeredAt;
}
