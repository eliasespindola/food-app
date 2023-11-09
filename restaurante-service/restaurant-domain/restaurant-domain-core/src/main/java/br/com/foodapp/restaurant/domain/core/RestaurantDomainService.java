package br.com.foodapp.restaurant.domain.core;

import br.com.foodapp.restaurant.domain.core.entity.Restaurant;

public interface RestaurantDomainService {
    Restaurant validateAndInitiateCustomer(Restaurant customer);
}
