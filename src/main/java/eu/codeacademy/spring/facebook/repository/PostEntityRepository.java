package eu.codeacademy.spring.facebook.repository;

import eu.codeacademy.spring.facebook.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {
}
