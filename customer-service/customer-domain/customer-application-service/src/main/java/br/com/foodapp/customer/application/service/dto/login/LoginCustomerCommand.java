package br.com.foodapp.customer.application.service.dto.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class LoginCustomerCommand {
    private final String email;
    private final String userName;
    private final String password;
}
