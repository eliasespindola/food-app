package br.com.foodapp.customer.application.service.ports.input;

import br.com.foodapp.customer.application.service.dto.create.CreateCustomerCommand;
import br.com.foodapp.customer.application.service.dto.create.CreateCustomerResponse;
import br.com.foodapp.customer.application.service.dto.login.LoginCustomerCommand;
import br.com.foodapp.customer.application.service.dto.login.LoginCustomerResponse;
import br.com.foodapp.customer.application.service.dto.track.TrackUserQuery;
import br.com.foodapp.customer.application.service.dto.track.TrackUserResponse;
import jakarta.validation.Valid;

public interface CustomerApplicationService {
    CreateCustomerResponse createCustomer(@Valid CreateCustomerCommand createCustomerCommand);
    LoginCustomerResponse login(@Valid LoginCustomerCommand loginCustomerCommand);

    TrackUserResponse findById(TrackUserQuery trackUserQuery);
}
