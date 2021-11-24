package eu.codeacademy.spring.facebook.security;

import eu.codeacademy.spring.facebook.entity.RoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {

    private final Long userId;
    private final String username;
    private final String password;
    private final Set<RoleEntity> roles;

    public Long getUserId() {
        return userId;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

            List<GrantedAuthority> authorities
                    = new ArrayList<>();
            for (RoleEntity role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
                role.getPermissions().stream()
                        .map(p -> new SimpleGrantedAuthority(p.getPermissionName()))
                        .forEach(authorities::add);
            }
            return authorities;
        }

        @Override
        public String getPassword () {
            return password;
        }

        @Override
        public String getUsername () {
            return username;
        }

        @Override
        public boolean isAccountNonExpired () {
            return true;
        }

        @Override
        public boolean isAccountNonLocked () {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired () {
            return true;
        }

        @Override
        public boolean isEnabled () {
            return true;
        }
    }
