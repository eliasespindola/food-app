package br.com.foodapp.restaurant.domain.core.valueobject;

import br.com.foodapp.common.security.entity.BaseEntity;
import br.com.foodapp.common.security.valueobject.DeliveryId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Delivery extends BaseEntity<DeliveryId> {
    private final BigDecimal fee;
    private final String time;

    private Delivery(Builder builder) {
        super.setId(builder.id);
        fee = builder.fee;
        time = builder.time;
    }


    public static final class Builder {
        private DeliveryId id;
        private BigDecimal fee;
        private String time;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withId(DeliveryId val) {
            id = val;
            return this;
        }

        public Builder withFee(BigDecimal val) {
            fee = val;
            return this;
        }

        public Builder withTime(String val) {
            time = val;
            return this;
        }

        public Delivery build() {
            return new Delivery(this);
        }
    }
}
