package eu.codeacademy.spring.facebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "permission")
@Getter
@Setter
@NoArgsConstructor
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer permissionId;

    @Column(name = "title")
    private String permissionName;

    @Column(name = "description")
    private String permissionDescription;
}
