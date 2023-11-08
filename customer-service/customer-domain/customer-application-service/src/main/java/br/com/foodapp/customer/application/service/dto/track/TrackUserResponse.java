package br.com.foodapp.customer.application.service.dto.track;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TrackUserResponse {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
}
