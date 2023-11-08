package br.com.foodapp.customer.dataaccess.customer.repository;

import br.com.foodapp.customer.dataaccess.customer.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleJpaRepository extends JpaRepository<RolesEntity,Long> {
    Optional<RolesEntity> findByName(String name);
}
