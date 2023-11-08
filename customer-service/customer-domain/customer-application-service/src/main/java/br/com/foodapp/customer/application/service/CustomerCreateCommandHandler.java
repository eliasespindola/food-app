package br.com.foodapp.customer.application.service;

import br.com.foodapp.customer.application.service.dto.create.CreateCustomerCommand;
import br.com.foodapp.customer.application.service.dto.create.CreateCustomerResponse;
import br.com.foodapp.customer.application.service.mapper.CustomerDataMapper;
import br.com.foodapp.customer.application.service.ports.output.repository.CustomerRepository;
import br.com.foodapp.customer.domain.core.CustomerDomainService;
import br.com.foodapp.customer.domain.core.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreateCommandHandler {
    private final CustomerDomainService customerDomainService;
    private final CustomerDataMapper mapper;
    private final CustomerRepository customerRepository;

    public CustomerCreateCommandHandler(CustomerDomainService customerDomainService, CustomerDataMapper mapper, CustomerRepository customerRepository) {
        this.customerDomainService = customerDomainService;
        this.mapper = mapper;
        this.customerRepository = customerRepository;
    }

    public CreateCustomerResponse create(CreateCustomerCommand createCustomerCommand) {
        final Customer customer = customerDomainService.validateAndInitiateCustomer(mapper.createCustomerToCustomer(createCustomerCommand));
        Customer customerSaved = customerRepository.save(customer);
        return mapper.customerToCreateCustomerResponse(customerSaved);
    }
}
