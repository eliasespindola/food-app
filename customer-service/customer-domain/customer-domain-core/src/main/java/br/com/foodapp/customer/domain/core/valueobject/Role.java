package br.com.foodapp.customer.domain.core.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    public static final Role ROLE_USER = new Role("ROLE_USER");
    private String name;
}
