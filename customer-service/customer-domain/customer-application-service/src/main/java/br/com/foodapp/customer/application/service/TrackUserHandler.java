package br.com.foodapp.customer.application.service;

import br.com.foodapp.customer.application.service.dto.track.TrackUserQuery;
import br.com.foodapp.customer.application.service.dto.track.TrackUserResponse;
import br.com.foodapp.customer.application.service.ports.output.repository.CustomerRepository;
import br.com.foodapp.customer.domain.core.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class TrackUserHandler {
    private final CustomerRepository customerRepository;

    public TrackUserHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public TrackUserResponse track(TrackUserQuery trackUserQuery) {
        final Customer customer = customerRepository.findById(trackUserQuery.getCustomerTrackingId());
        return TrackUserResponse.builder()
                .id(customer.getId().getValue())
                .userName(customer.getUserName())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }
}
