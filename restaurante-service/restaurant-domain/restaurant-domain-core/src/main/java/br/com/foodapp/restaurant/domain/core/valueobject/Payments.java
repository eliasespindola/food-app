package br.com.foodapp.restaurant.domain.core.valueobject;

import br.com.foodapp.common.security.entity.BaseEntity;
import br.com.foodapp.common.security.valueobject.PaymentCategory;
import br.com.foodapp.common.security.valueobject.PaymentsId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Payments extends BaseEntity<PaymentsId> {
    private final PaymentCategory category;
    private final String name;

    private Payments(Builder builder) {
        setId(builder.id);
        category = builder.category;
        name = builder.name;
    }


    public static final class Builder {
        private PaymentsId id;
        private PaymentCategory category;
        private String name;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withId(PaymentsId val) {
            id = val;
            return this;
        }

        public Builder withCategory(PaymentCategory val) {
            category = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Payments build() {
            return new Payments(this);
        }
    }
}
