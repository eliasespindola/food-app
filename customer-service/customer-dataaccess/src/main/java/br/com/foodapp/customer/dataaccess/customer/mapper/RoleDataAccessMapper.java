package br.com.foodapp.customer.dataaccess.customer.mapper;

import br.com.foodapp.customer.dataaccess.customer.entity.RolesEntity;
import br.com.foodapp.customer.dataaccess.customer.repository.RoleJpaRepository;
import br.com.foodapp.customer.domain.core.exception.CustomerDomainException;
import br.com.foodapp.customer.domain.core.valueobject.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoleDataAccessMapper {
    private final RoleJpaRepository roleJpaRepository;

    public RoleDataAccessMapper(RoleJpaRepository roleJpaRepository) {
        this.roleJpaRepository = roleJpaRepository;
    }

    public Set<RolesEntity> roleToRoleEntity(List<Role> roles) {
        return roles.stream().map(i -> roleJpaRepository.findByName(i.getName()).orElseThrow(() -> new CustomerDomainException("""
                Role with %s name not found
                """.formatted(i.getName())))).collect(Collectors.toSet());
    }

    public List<Role> roleEntityToRole(Set<RolesEntity> roles) {
        return roles.stream().map(i -> new Role(i.getName())).collect(Collectors.toList());
    }
}
