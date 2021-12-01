package eu.codeacademy.spring.facebook.service.impl;


import eu.codeacademy.spring.facebook.entity.UserEntity;
import eu.codeacademy.spring.facebook.model.User;
import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
import eu.codeacademy.spring.facebook.request.UserRequest;
import eu.codeacademy.spring.facebook.security.PasswordService;
import eu.codeacademy.spring.facebook.security.SecurityConfig;
import eu.codeacademy.spring.facebook.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {

    private final UserEntityRepository userEntityRepository;

    private final PasswordService passwordService;

    @Override
    public List<User> getAllUsers() {
        return userEntityRepository.findAll().stream().map(this::createUserFromEntity).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<User> getUser() {
        return Optional.empty();
    }

    @Override
    public void registerUser(UserRequest request) {
        var entity = new UserEntity();
        entity.setRoleId(2);
        entity.setUsername(request.getUsername());
        entity.setPassword(passwordService.passwordEncoder().encode(request.getPassword()));
        entity.setEmail(request.getEmail());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setRegisteredAt(LocalDateTime.now());
        userEntityRepository.saveAndFlush(entity);
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
                .roleId(entity.getRoleId())
                .build();
    }


}
