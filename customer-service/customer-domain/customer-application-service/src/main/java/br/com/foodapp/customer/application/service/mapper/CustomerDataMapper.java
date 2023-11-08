package br.com.foodapp.customer.application.service.mapper;

import br.com.foodapp.customer.application.service.dto.create.CreateCustomerCommand;
import br.com.foodapp.customer.application.service.dto.create.CreateCustomerResponse;
import br.com.foodapp.customer.application.service.dto.login.LoginCustomerCommand;
import br.com.foodapp.customer.domain.core.entity.Customer;
import br.com.foodapp.customer.domain.core.valueobject.Password;
import br.com.foodapp.customer.domain.core.valueobject.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static br.com.foodapp.customer.domain.core.valueobject.Role.ROLE_USER;

@Component
public class CustomerDataMapper {
    public Customer loginCustomerToCustomer(LoginCustomerCommand loginCustomerCommand, Password password) {
        return Customer.Builder.builder()
                .withEmail(loginCustomerCommand.getEmail())
                .withUserName(loginCustomerCommand.getUserName())
                .withPassword(password)
                .build();
    }

    public Customer createCustomerToCustomer(CreateCustomerCommand createCustomerCommand) {
        return Customer.Builder.builder()
                .withUserName(createCustomerCommand.getUserName())
                .withFirstName(createCustomerCommand.getFirstName())
                .withEmail(createCustomerCommand.getEmail())
                .withPassword(new Password(createCustomerCommand.getPassword()))
                .withCreatedAt(LocalDateTime.now())
                .withRoles(List.of(ROLE_USER))
                .build();
    }

    public CreateCustomerResponse customerToCreateCustomerResponse(Customer customerSaved) {
        return CreateCustomerResponse.builder()
                .id(customerSaved.getId().getValue())
                .firstName(customerSaved.getFirstName())
                .lastName(customerSaved.getLastName())
                .userName(customerSaved.getUserName())
                .email(customerSaved.getEmail())
                .build();
    }
}
