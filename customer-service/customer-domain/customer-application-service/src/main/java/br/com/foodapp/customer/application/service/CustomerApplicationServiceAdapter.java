package br.com.foodapp.customer.application.service;

import br.com.foodapp.customer.application.service.dto.create.CreateCustomerCommand;
import br.com.foodapp.customer.application.service.dto.create.CreateCustomerResponse;
import br.com.foodapp.customer.application.service.dto.login.LoginCustomerCommand;
import br.com.foodapp.customer.application.service.dto.login.LoginCustomerResponse;
import br.com.foodapp.customer.application.service.dto.track.TrackUserQuery;
import br.com.foodapp.customer.application.service.dto.track.TrackUserResponse;
import br.com.foodapp.customer.application.service.ports.input.CustomerApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CustomerApplicationServiceAdapter implements CustomerApplicationService {

    private final CustomerCreateCommandHandler customerCreateCommandHandler;
    private final LoginCustomerHandler loginCustomerHandler;
    private final TrackUserHandler trackUserHandler;

    public CustomerApplicationServiceAdapter(CustomerCreateCommandHandler customerCreateCommandHandler, LoginCustomerHandler loginCustomerHandler, TrackUserHandler trackUserHandler) {
        this.customerCreateCommandHandler = customerCreateCommandHandler;
        this.loginCustomerHandler = loginCustomerHandler;
        this.trackUserHandler = trackUserHandler;
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerCommand createCustomerCommand) {
        return customerCreateCommandHandler.create(createCustomerCommand);
    }

    @Override
    public LoginCustomerResponse login(LoginCustomerCommand loginCustomerCommand) {
        return loginCustomerHandler.login(loginCustomerCommand);
    }

    @Override
    public TrackUserResponse findById(TrackUserQuery trackUserQuery) {
        return trackUserHandler.track(trackUserQuery);
    }
}
