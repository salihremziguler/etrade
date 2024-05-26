package com.enoca.etrade.business.abstracts;

import com.enoca.etrade.business.dtos.request.CreateCustomerRequest;
import com.enoca.etrade.business.dtos.response.CreatedCustomerResponse;


public interface CustomerService {

    CreatedCustomerResponse addCustomer(CreateCustomerRequest createCustomerRequest);

}
