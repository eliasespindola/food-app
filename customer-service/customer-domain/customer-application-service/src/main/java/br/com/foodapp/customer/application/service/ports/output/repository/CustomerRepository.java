package br.com.foodapp.customer.application.service.ports.output.repository;

import br.com.foodapp.customer.domain.core.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Customer findByEmail(final String email);

    Customer save(final Customer customer);

    Customer findById(UUID customerTrackingId);
}
