package eu.codeacademy.spring.facebook.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.codeacademy.spring.facebook.entity.RoleEntity;
import eu.codeacademy.spring.facebook.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {

    private final Long userId;
    private final String username;
    @JsonIgnore
    private final String password;
    private final Set<RoleEntity> roles;


    public Long getUserId() {
        return userId;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] userRoles = roles.stream().map((RoleEntity::getRoleName)).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    private Role createRoleFromEntity(RoleEntity entity){
        var role = new Role();
        role.setRoleName(entity.getRoleName());
        return role;
    }
}
