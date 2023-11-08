package br.com.foodapp.customer.container.bean;

import br.com.foodapp.customer.domain.core.CustomerDomainService;
import br.com.foodapp.customer.domain.core.CustomerDomainServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerDomainServiceBean {
    @Bean
    public CustomerDomainService customerDomainService(){
        return new CustomerDomainServiceAdapter();
    }
}
