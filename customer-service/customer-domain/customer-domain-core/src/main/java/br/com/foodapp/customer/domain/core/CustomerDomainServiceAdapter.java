package br.com.foodapp.customer.domain.core;

import br.com.foodapp.customer.domain.core.entity.Customer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerDomainServiceAdapter implements CustomerDomainService{
    @Override
    public Customer validateAndInitiateCustomer(Customer customer) {
       customer.validateCustomer();
       customer.initializeCustomer();
       log.info("Customer with id: {} is initiated", customer.getId().getValue());
       return customer;
    }
}
