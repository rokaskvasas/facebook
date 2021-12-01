package eu.codeacademy.spring.facebook.repository;

import eu.codeacademy.spring.facebook.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {

    Optional<PostEntity> getByPostId(Long postId);
    Optional<PostEntity> findAllByUserId(Long userId);
}
