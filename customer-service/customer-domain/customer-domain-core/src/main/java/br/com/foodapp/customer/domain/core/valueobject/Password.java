package br.com.foodapp.customer.domain.core.valueobject;

import br.com.foodapp.customer.domain.core.exception.CustomerDomainException;

public class Password {
    private final String password;

    public Password(String password) {
        this.password = password;
    }

    public String get() {
        return password;
    }

    public void validatePassword() {
        if(this.password.length() < 6){
            throw  new CustomerDomainException("Password too small");
        }
    }
}
