package br.com.foodapp.restaurant.domain.core.valueobject;

import br.com.foodapp.common.security.entity.BaseEntity;
import br.com.foodapp.common.security.valueobject.ReviewId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Review extends BaseEntity<ReviewId> {
    private final Double stars;
    private final String comment;

    private Review(Builder builder) {
        setId(builder.id);
        stars = builder.stars;
        comment = builder.comment;
    }


    public static final class Builder {
        private ReviewId id;
        private Double stars;
        private String comment;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withId(ReviewId val) {
            id = val;
            return this;
        }

        public Builder withStars(Double val) {
            stars = val;
            return this;
        }

        public Builder withComment(String val) {
            comment = val;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
