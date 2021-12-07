package eu.codeacademy.spring.facebook.service;

import eu.codeacademy.spring.facebook.entity.UserEntity;
import eu.codeacademy.spring.facebook.model.User;
import eu.codeacademy.spring.facebook.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserEntityService {

//    User createUser(UserRequest request);

    List<User> getAllUsers();

    List<User> getAllUsersTest();

    List<UserEntity> getAllUsersEntity();

    Optional<User> getUser();

    void registerUser(UserRequest request);

    UserEntity getUserEntity(String username);
}
