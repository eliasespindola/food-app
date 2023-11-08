package br.com.foodapp.customer.application.service.dto.track;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TrackUserQuery {
    @NotNull
    private final UUID customerTrackingId;
}
