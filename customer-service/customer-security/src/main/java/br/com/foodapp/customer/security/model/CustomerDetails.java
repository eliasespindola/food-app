package br.com.foodapp.customer.security.model;

import br.com.foodapp.customer.domain.core.entity.Customer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class CustomerDetails  {

    private final UUID id;
    private final String email;
    private final String userName;
    private final String password;
    private final List<RoleDetails> roles = new ArrayList<>();

    public CustomerDetails(Customer customer){
        this.id = customer.getId().getValue();
        this.email = customer.getEmail();
        this.userName = customer.getUserName();
        this.password = customer.getPassword().get();
        this.roles.addAll(customer.getRoles().stream().map(i -> new RoleDetails(i.getName())).toList());
    }


}
