package br.com.foodapp.customer.security.model;

import java.util.Objects;

public class RoleDetails{
    private final String authority;

    public RoleDetails(String authority) {
        this.authority = authority;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDetails that = (RoleDetails) o;
        return Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority);
    }
}
