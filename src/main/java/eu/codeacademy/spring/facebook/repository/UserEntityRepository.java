package eu.codeacademy.spring.facebook.repository;

import eu.codeacademy.spring.facebook.entity.UserEntity;
import eu.codeacademy.spring.facebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameOrEmail(String username, String email);

    Optional<UserEntity> findByUserId(Long id);

    Optional<UserEntity> findByUsername(String username);
}
