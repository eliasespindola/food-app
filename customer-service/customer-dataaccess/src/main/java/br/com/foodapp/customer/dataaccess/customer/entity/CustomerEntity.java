package br.com.foodapp.customer.dataaccess.customer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@Builder
@Getter
@AllArgsConstructor
@Table(name = "customers")
@NoArgsConstructor(force = true)
public class CustomerEntity {
    @Id
    private final UUID id;
    private final String firstName;
    private final String lastName;
    @Column(unique = true)
    @NotBlank(message = "Username cannot be empty")
    private final String userName;
    @Email(message = "Email invalid")
    @Column(unique = true)
    private final String email;
    private final String password;
    private final OffsetDateTime createdAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customers_roles",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private final Set<RolesEntity> roles;


}
