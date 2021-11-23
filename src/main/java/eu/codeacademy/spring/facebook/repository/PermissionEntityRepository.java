package eu.codeacademy.spring.facebook.repository;

import eu.codeacademy.spring.facebook.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionEntityRepository extends JpaRepository<PermissionEntity, Integer> {
}
