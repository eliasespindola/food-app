package br.com.foodapp.restaurant.dataaccess.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class OpeningHoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    @Enumerated(EnumType.STRING)
    private final DayOfWeek dayOfWeek;
    private final String open;
    private final String close;
    private final Boolean closedOnHolidays;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;
}
