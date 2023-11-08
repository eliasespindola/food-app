package br.com.foodapp.customer.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"br.com.foodapp.customer.dataaccess.customer"})
@EntityScan(basePackages = {"br.com.foodapp.customer.dataaccess.customer"})
@SpringBootApplication(scanBasePackages = "br.com.foodapp")
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
