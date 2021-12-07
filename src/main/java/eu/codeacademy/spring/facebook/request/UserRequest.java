package eu.codeacademy.spring.facebook.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private Long userId;

    @NotBlank
    @Size(min = 1,max = 15)
    private String firstName;

    @NotBlank
    @Size(min = 1,max = 15)
    private String lastName;

    @NotBlank
    @Column(unique = true)
    @Size(min = 1,max = 15)
    private String username;

    @NotBlank
    @Size(min = 4,max = 20)
    private String password;

    @NotBlank
    @Column(unique = true)
    private String email;

    private LocalDateTime registeredAt;
}
