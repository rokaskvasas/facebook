package eu.codeacademy.spring.facebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer roleId;

    @Column(name = "title")
    private String roleName;

    @Column(name = "description")
    private String roleDescription;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private UserEntity userRole;

}
