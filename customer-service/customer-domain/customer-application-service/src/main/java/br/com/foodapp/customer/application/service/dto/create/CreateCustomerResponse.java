package br.com.foodapp.customer.application.service.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CreateCustomerResponse {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
}
