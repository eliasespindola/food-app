package br.com.foodapp.restaurant.domain.core.valueobject;

import br.com.foodapp.common.security.entity.BaseEntity;
import br.com.foodapp.common.security.valueobject.OpeningHoursId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;

@Getter
@AllArgsConstructor
public class OpeningHours extends BaseEntity<OpeningHoursId> {
    private final DayOfWeek dayOfWeek;
    private final String open;
    private final String close;
    private final Boolean closedOnHolidays;

    private OpeningHours(Builder builder) {
        setId(builder.id);
        dayOfWeek = builder.dayOfWeek;
        open = builder.open;
        close = builder.close;
        closedOnHolidays = builder.closedOnHolidays;
    }


    public static final class Builder {
        private OpeningHoursId id;
        private DayOfWeek dayOfWeek;
        private String open;
        private String close;
        private Boolean closedOnHolidays;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withId(OpeningHoursId val) {
            id = val;
            return this;
        }

        public Builder withDayOfWeek(DayOfWeek val) {
            dayOfWeek = val;
            return this;
        }

        public Builder withOpen(String val) {
            open = val;
            return this;
        }

        public Builder withClose(String val) {
            close = val;
            return this;
        }

        public Builder withClosedOnHolidays(Boolean val) {
            closedOnHolidays = val;
            return this;
        }

        public OpeningHours build() {
            return new OpeningHours(this);
        }
    }
}
