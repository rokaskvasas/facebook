package eu.codeacademy.spring.facebook.service.impl;


import eu.codeacademy.spring.facebook.entity.RoleEntity;
import eu.codeacademy.spring.facebook.entity.UserEntity;
import eu.codeacademy.spring.facebook.model.User;
import eu.codeacademy.spring.facebook.repository.RoleEntityRepository;
import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
import eu.codeacademy.spring.facebook.request.UserRequest;
import eu.codeacademy.spring.facebook.security.PasswordService;
import eu.codeacademy.spring.facebook.security.SecurityConfig;
import eu.codeacademy.spring.facebook.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final RoleEntityRepository roleEntityRepository;

    private final PasswordService passwordService;

    @Override
    public List<User> getAllUsers() {
        return userEntityRepository.findAll().stream().map(this::createUserFromEntity).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<User> getAllUsersTest() {
        return userEntityRepository.findAll().stream().map(this::createUserFromEntity).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<UserEntity> getAllUsersEntity() {
        return userEntityRepository.findAll();
    }

    @Override
    public Optional<User> getUser() {
        return Optional.empty();
    }

    @Override
    public void registerUser(UserRequest request) {
        var entity = new UserEntity();
        entity.setUsername(request.getUsername());
        entity.setPassword(passwordService.passwordEncoder().encode(request.getPassword()));
        entity.setEmail(request.getEmail());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setRegisteredAt(LocalDateTime.now());
        entity.setRoles(roleEntityRepository.findById(2).stream().collect(Collectors.toSet()));
        userEntityRepository.saveAndFlush(entity);
    }

    @Override
    public UserEntity getUserEntity(String username) {
        var entity = userEntityRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: "+username));
        return entity;
    }

    private User createUserFromEntity(UserEntity entity) {

        return User.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .username(entity.getUsername())
                .registeredAt(entity.getRegisteredAt())
                .userId(entity.getUserId())
                .build();
    }


}
