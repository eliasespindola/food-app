package br.com.foodapp.customer.domain.core.entity;

import br.com.foodapp.common.security.entity.AggregateRoot;
import br.com.foodapp.common.security.valueobject.CustomerId;
import br.com.foodapp.customer.domain.core.exception.CustomerDomainException;
import br.com.foodapp.customer.domain.core.valueobject.Password;
import br.com.foodapp.customer.domain.core.valueobject.Role;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class Customer extends AggregateRoot<CustomerId> {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
    private final Password password;
    private final List<Role> roles;
    private final LocalDateTime createdAt;

    public Customer(CustomerId customerId,
                    String firstName,
                    String lastName,
                    String userName,
                    String email,
                    Password password,
                    List<Role> roles) {

        super.setId(customerId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.createdAt = LocalDateTime.now();
    }

    private Customer(Builder builder) {
        setId(builder.id);
        firstName = builder.firstName;
        lastName = builder.lastName;
        userName = builder.userName;
        email = builder.email;
        password = builder.password;
        roles = builder.roles;
        createdAt = builder.createdAt;
    }

    public void initializeCustomer(){
        setId(new CustomerId(UUID.randomUUID()));
    }

    public void validateCustomer(){
        validateEmail();
        validateNames();
        validatePassword();
    }

    private void validateNames() {
        if(firstName.length() < 2 && lastName.length() < 2 && userName.length() < 2){
            throw new CustomerDomainException("First name, last name or username is invalid, cannot be less 2");
        }
    }

    private void validateEmail() {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.email);

        if(!matcher.matches()){
            throw new CustomerDomainException("Email invalid");
        }
    }

    private void validatePassword() {
        password.validatePassword();
    }


    public static final class Builder {
        private CustomerId id;
        private String firstName;
        private String lastName;
        private String userName;
        private String email;
        private Password password;
        private List<Role> roles;
        private LocalDateTime createdAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withId(CustomerId val) {
            id = val;
            return this;
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withUserName(String val) {
            userName = val;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withPassword(Password val) {
            password = val;
            return this;
        }

        public Builder withRoles(List<Role> val) {
            roles = val;
            return this;
        }

        public Builder withCreatedAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
