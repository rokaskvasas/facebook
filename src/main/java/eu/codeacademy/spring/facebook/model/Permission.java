package eu.codeacademy.spring.facebook.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Permission {

    private Integer permissionId;

    private String permissionName;

    private String permissionDescription;
}
