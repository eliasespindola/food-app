package br.com.foodapp.customer.application.rest;

import br.com.foodapp.customer.application.service.dto.create.CreateCustomerCommand;
import br.com.foodapp.customer.application.service.dto.create.CreateCustomerResponse;
import br.com.foodapp.customer.application.service.dto.login.LoginCustomerCommand;
import br.com.foodapp.customer.application.service.dto.login.LoginCustomerResponse;
import br.com.foodapp.customer.application.service.dto.track.TrackUserQuery;
import br.com.foodapp.customer.application.service.dto.track.TrackUserResponse;
import br.com.foodapp.customer.application.service.ports.input.CustomerApplicationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/customers", produces = "application/vnd.api.v1+json")
public class CustomerController {

    private final CustomerApplicationService service;

    public CustomerController(CustomerApplicationService service) {
        this.service = service;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginCustomerResponse> login(@RequestBody @Valid final LoginCustomerCommand loginCustomerCommand){
        return ResponseEntity.ok(service.login(loginCustomerCommand));
    }

    @PostMapping("/auth/create")
    public ResponseEntity<CreateCustomerResponse> create(@RequestBody @Valid final CreateCustomerCommand createCustomerCommand){
        final CreateCustomerResponse customerResponse = service.createCustomer(createCustomerCommand);
        final URI location = URI.create("/api/users/" + customerResponse.getId());
        return ResponseEntity.created(location).body(customerResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackUserResponse> findById(@PathVariable("id") TrackUserQuery trackUserQuery){
        TrackUserResponse trackUserResponse = service.findById(trackUserQuery);
        return ResponseEntity.ok(trackUserResponse);
    }
}
