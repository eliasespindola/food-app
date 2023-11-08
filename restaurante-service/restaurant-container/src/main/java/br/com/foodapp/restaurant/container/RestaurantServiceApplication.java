package br.com.foodapp.restaurant.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"br.com.foodapp.restaurant.dataaccess"})
@EntityScan(basePackages = {"br.com.foodapp.restaurant.dataaccess"})
@SpringBootApplication(scanBasePackages = "br.com.foodapp")
public class RestaurantServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }
}
