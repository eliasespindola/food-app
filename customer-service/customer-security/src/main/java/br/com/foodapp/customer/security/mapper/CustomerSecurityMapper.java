package br.com.foodapp.customer.security.mapper;

import br.com.foodapp.customer.domain.core.entity.Customer;
import br.com.foodapp.customer.security.model.CustomerDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerSecurityMapper {

    public CustomerDetails customerToCustomerDetails(final Customer customer){
        return new CustomerDetails(customer);
    }
}
