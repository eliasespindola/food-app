package br.com.foodapp.customer.application.service;

import br.com.foodapp.customer.application.service.dto.login.LoginCustomerCommand;
import br.com.foodapp.customer.application.service.dto.login.LoginCustomerResponse;
import br.com.foodapp.customer.application.service.mapper.CustomerDataMapper;
import br.com.foodapp.customer.application.service.ports.output.repository.CustomerRepository;
import br.com.foodapp.customer.application.service.ports.output.security.TokenManager;
import br.com.foodapp.customer.domain.core.entity.Customer;
import br.com.foodapp.customer.domain.core.exception.CustomerDomainException;
import br.com.foodapp.customer.domain.core.valueobject.TokenType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginCustomerHandler {
    private final TokenManager tokenManager;
    private final CustomerRepository customerRepository;

    public LoginCustomerHandler(TokenManager tokenManager, CustomerRepository customerRepository) {
        this.tokenManager = tokenManager;
        this.customerRepository = customerRepository;
    }

    public LoginCustomerResponse login(LoginCustomerCommand loginCustomerCommand) {
        Customer customer = customerRepository.findByEmail(loginCustomerCommand.getEmail());
        final String token = tokenManager.generateToken(customer);
        tokenManager.isValid(token);
        return new LoginCustomerResponse(token, TokenType.BEARER.getName());
    }
}
