package br.com.foodapp.customer.application.service.ports.output.security;

import br.com.foodapp.customer.domain.core.entity.Customer;

import java.util.UUID;

public interface TokenManager {
    String generateToken(Customer customer);
    boolean isValid(String token);

    UUID getUserIdFromToken(String token);
}
