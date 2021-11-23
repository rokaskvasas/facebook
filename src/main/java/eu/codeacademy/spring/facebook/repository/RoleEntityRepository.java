package eu.codeacademy.spring.facebook.repository;

import eu.codeacademy.spring.facebook.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {
}
