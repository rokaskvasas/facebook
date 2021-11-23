package eu.codeacademy.spring.facebook.repository;

import eu.codeacademy.spring.facebook.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagEntityRepository extends JpaRepository<TagEntity, Long> {
}
