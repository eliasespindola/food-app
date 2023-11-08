package br.com.foodapp.customer.application.service.dto.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class LoginCustomerResponse {
    private final String value;
    private final String type;
}
