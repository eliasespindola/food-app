package br.com.foodapp.customer.dataaccess.customer.mapper;

import br.com.foodapp.common.security.valueobject.CustomerId;
import br.com.foodapp.customer.dataaccess.customer.entity.CustomerEntity;
import br.com.foodapp.customer.domain.core.entity.Customer;
import br.com.foodapp.customer.domain.core.valueobject.Password;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Component
public class CustomerDataAccessMapper {
    private final RoleDataAccessMapper roleDataAccessMapper;

    public CustomerDataAccessMapper(RoleDataAccessMapper roleDataAccessMapper) {
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return Customer.Builder.builder()
                .withId(new CustomerId(customerEntity.getId()))
                .withUserName(customerEntity.getUserName())
                .withFirstName(customerEntity.getFirstName())
                .withLastName(customerEntity.getLastName())
                .withPassword(new Password(customerEntity.getPassword()))
                .withEmail(customerEntity.getEmail())
                .withCreatedAt(customerEntity.getCreatedAt().toLocalDateTime())
                .withRoles(roleDataAccessMapper.roleEntityToRole(customerEntity.getRoles()))
                .build();
    }

    public CustomerEntity customerToEntity(Customer customer) {
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneOffset zoneOffset = zoneId.getRules().getOffset(localDateTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);

        return CustomerEntity.builder()
                .id(customer.getId().getValue())
                .userName(customer.getUserName())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .password(customer.getPassword().get())
                .email(customer.getEmail())
                .createdAt(offsetDateTime)
                .roles(roleDataAccessMapper.roleToRoleEntity(customer.getRoles()))
                .build();
    }
}
