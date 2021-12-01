package eu.codeacademy.spring.facebook.service;

import eu.codeacademy.spring.facebook.model.User;
import eu.codeacademy.spring.facebook.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserEntityService {

//    User createUser(UserRequest request);

    List<User> getAllUsers();

    Optional<User> getUser();

    void registerUser(UserRequest request);
}
