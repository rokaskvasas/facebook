package eu.codeacademy.spring.facebook.security;

import eu.codeacademy.spring.facebook.entity.UserEntity;
import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        return userEntityRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                .map(this::convertUserEntityToPrincipal)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

    private UserPrincipal convertUserEntityToPrincipal(UserEntity user){
        return new UserPrincipal(user.getUserId(), user.getUsername(), user.getPassword(), user.getRoles());
    }
}
