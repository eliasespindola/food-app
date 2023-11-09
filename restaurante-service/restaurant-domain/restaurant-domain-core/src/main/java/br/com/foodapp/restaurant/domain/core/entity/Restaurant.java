package br.com.foodapp.restaurant.domain.core.entity;

import br.com.foodapp.common.security.entity.AggregateRoot;
import br.com.foodapp.common.security.valueobject.Address;
import br.com.foodapp.common.security.valueobject.RestaurantId;
import br.com.foodapp.restaurant.domain.core.valueobject.*;

import java.math.BigDecimal;
import java.util.Set;

public class Restaurant extends AggregateRoot<RestaurantId> {
    private final String name;
    private final String category;
    private final String logo;
    private final String description;
    private final Address address;
    private final String cnpj;
    private final Set<OpeningHours> openingHours;
    private final Set<Payments> payments;
    private final Set<Item> items;
    private final Set<Review> reviews;
    private final Delivery delivery;
    private final BigDecimal minimumOrder;
    private final Double stars;

    private Restaurant(Builder builder) {
        super.setId(builder.id);
        name = builder.name;
        category = builder.category;
        logo = builder.logo;
        description = builder.description;
        address = builder.address;
        cnpj = builder.cnpj;
        openingHours = builder.openingHours;
        payments = builder.payments;
        items = builder.items;
        reviews = builder.reviews;
        delivery = builder.delivery;
        minimumOrder = builder.minimumOrder;
        stars = builder.stars;
    }


    public static final class Builder {
        private RestaurantId id;
        private String name;
        private String category;
        private String logo;
        private String description;
        private Address address;
        private String cnpj;
        private Set<OpeningHours> openingHours;
        private Set<Payments> payments;
        private Set<Item> items;
        private Set<Review> reviews;
        private Delivery delivery;
        private BigDecimal minimumOrder;
        private Double stars;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withId(RestaurantId val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withCategory(String val) {
            category = val;
            return this;
        }

        public Builder withLogo(String val) {
            logo = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withAddress(Address val) {
            address = val;
            return this;
        }

        public Builder withCnpj(String val) {
            cnpj = val;
            return this;
        }

        public Builder withOpeningHours(Set<OpeningHours> val) {
            openingHours = val;
            return this;
        }

        public Builder withPayments(Set<Payments> val) {
            payments = val;
            return this;
        }

        public Builder withItems(Set<Item> val) {
            items = val;
            return this;
        }

        public Builder withReviews(Set<Review> val) {
            reviews = val;
            return this;
        }

        public Builder withDelivery(Delivery val) {
            delivery = val;
            return this;
        }

        public Builder withMinimumOrder(BigDecimal val) {
            minimumOrder = val;
            return this;
        }

        public Builder withStars(Double val) {
            stars = val;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
