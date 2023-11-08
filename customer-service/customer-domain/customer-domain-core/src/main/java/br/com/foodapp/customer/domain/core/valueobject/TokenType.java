package br.com.foodapp.customer.domain.core.valueobject;

public enum TokenType {
    BEARER("Bearer");
    private final String name;

    TokenType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
