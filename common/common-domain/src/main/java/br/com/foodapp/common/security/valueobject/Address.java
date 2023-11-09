package br.com.foodapp.common.security.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Address {
    private final Long id;
    private final String cep;
    private final String uf;
    private final String city;
    private final String street;
    private final Integer number;
    private final String complement;
    private final String vicinage;
}
