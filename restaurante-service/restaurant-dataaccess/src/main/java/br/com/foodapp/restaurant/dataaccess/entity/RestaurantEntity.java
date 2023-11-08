package br.com.foodapp.restaurant.dataaccess.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class RestaurantEntity {
    @Id
    private final UUID id;
    @Enumerated(EnumType.STRING)
    private final Category category;
    private final String logo;
    private final String description;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OpeningHoursEntity> openingHours;
    @OneToOne
    private final AddressEntity address;
    private final String cnpj;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<PaymentsEntity> payments;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<ItemEntity> items;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<ReviewEntity> reviews;
    @OneToOne
    private final DeliveryEntity delivery;
    private final BigDecimal minimumOrder;
    private final Double stars;
}
