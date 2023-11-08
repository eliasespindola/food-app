package br.com.foodapp.customer.application.service.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CreateCustomerCommand {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
    private final String password;
}
