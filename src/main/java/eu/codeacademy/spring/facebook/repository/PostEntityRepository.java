package eu.codeacademy.spring.facebook.repository;

import eu.codeacademy.spring.facebook.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {

    Optional<PostEntity> getByPostId(Long postId);
    Page<PostEntity> findAllByUserId(Long userId, Pageable pageable);

    @Modifying
    void removePostEntityByPostId(Long postId);
}
