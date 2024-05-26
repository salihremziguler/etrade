package com.enoca.etrade.api.controller;

import com.enoca.etrade.business.abstracts.CustomerService;
import com.enoca.etrade.business.dtos.request.CreateCustomerRequest;
import com.enoca.etrade.business.dtos.response.CreatedCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private CustomerService customerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCustomerResponse add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.addCustomer(createCustomerRequest);
    }

}
