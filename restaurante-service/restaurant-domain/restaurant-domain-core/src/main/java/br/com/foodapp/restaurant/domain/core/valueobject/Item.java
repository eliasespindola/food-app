package br.com.foodapp.restaurant.domain.core.valueobject;

import br.com.foodapp.common.security.entity.BaseEntity;
import br.com.foodapp.common.security.valueobject.ItemId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
@AllArgsConstructor
public class Item extends BaseEntity<ItemId> {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Integer quantity;
    private final String url;

    private Item(Builder builder) {
        setId(builder.id);
        name = builder.name;
        description = builder.description;
        quantity = builder.quantity;
        price = builder.price;
        url = builder.url;
    }


    public static final class Builder {
        private ItemId id;
        private String name;
        private String description;
        private BigDecimal price;
        private Integer quantity;
        private String url;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withId(ItemId val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withQuantity(Integer val) {
            quantity = val;
            return this;
        }
        public Builder withPrice(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder withUrl(String val) {
            url = val;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
