package br.com.foodapp.customer.dataaccess.customer.adapter;

import br.com.foodapp.customer.application.service.ports.output.repository.CustomerRepository;
import br.com.foodapp.customer.dataaccess.customer.entity.CustomerEntity;
import br.com.foodapp.customer.dataaccess.customer.mapper.CustomerDataAccessMapper;
import br.com.foodapp.customer.dataaccess.customer.repository.CustomerJpaRepository;
import br.com.foodapp.customer.domain.core.entity.Customer;
import br.com.foodapp.customer.domain.core.exception.CustomerDomainException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepositoryAdapter implements CustomerRepository {
    private final CustomerJpaRepository repository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerRepositoryAdapter(CustomerJpaRepository repository, CustomerDataAccessMapper customerDataAccessMapper) {
        this.repository = repository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Customer findByEmail(String email) {
        CustomerEntity customerEntity = repository.findByEmail(email).orElseThrow(() -> new CustomerDomainException("""
                Customer with %s email not found
                """.formatted(email)));

        return customerDataAccessMapper.customerEntityToCustomer(customerEntity);
    }

    @Override
    public Customer save(Customer customer) {
        return customerDataAccessMapper.customerEntityToCustomer(
                repository.save(
                        customerDataAccessMapper.customerToEntity(customer)));
    }

    @Override
    public Customer findById(UUID customerTrackingId) {
        return customerDataAccessMapper.customerEntityToCustomer(repository.findById(customerTrackingId).orElseThrow(() -> new CustomerDomainException("""
                Customer with id %s  not found
                """.formatted(customerTrackingId))));
    }
}
