package eu.codeacademy.spring.facebook.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.codeacademy.spring.facebook.entity.RoleEntity;
import eu.codeacademy.spring.facebook.model.Permission;
import eu.codeacademy.spring.facebook.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

//        TODO:: endless permissions and roles doesn't sets right by DB(entity problem).
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
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


    private Set<Role> entitySetToRoleSet(Set<RoleEntity> entity){
        return entity.stream().map(this::createRoleFromEntity).collect(Collectors.toSet());
    }

    private Role createRoleFromEntity(RoleEntity entity){
        var role = new Role();
        role.setRoleName(entity.getRoleName());
        return role;
    }
}
