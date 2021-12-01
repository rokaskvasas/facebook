package eu.codeacademy.spring.facebook.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    private Integer permissionId;

    private String permissionName;

    private String permissionDescription;
}
