package br.com.foodapp.restaurant.dataaccess.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class AddressEntity {
    @Id
    private final Long id;
    private final String cep;
    private final String uf;
    private final String city;
    private final String street;
    private final Integer number;
    private final String complement;
    private final String vicinage;
}
