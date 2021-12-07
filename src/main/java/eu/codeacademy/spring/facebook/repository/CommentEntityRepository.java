package eu.codeacademy.spring.facebook.repository;

import eu.codeacademy.spring.facebook.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentEntityRepository extends JpaRepository<CommentEntity, Long> {

    @Modifying
    void removeByCommentId(Long commentId);

    @Override
    Optional<CommentEntity> findById(Long aLong);
}
