package br.com.foodapp.customer.domain.core;

import br.com.foodapp.customer.domain.core.entity.Customer;

public interface CustomerDomainService {
    Customer validateAndInitiateCustomer(Customer customer);
}
