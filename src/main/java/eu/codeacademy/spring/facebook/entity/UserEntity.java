package eu.codeacademy.spring.facebook.entity;

import eu.codeacademy.spring.facebook.validation.ValidUsername;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;

    @Column(name = "registered_at")
    @Timestamp
    private LocalDateTime registeredAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<RoleEntity> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userPost")
    private List<PostEntity> postEntityList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userComment")
    private List<CommentEntity> userComments;
}
