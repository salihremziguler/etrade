package com.enoca.etrade.business.concretes;

import com.enoca.etrade.business.abstracts.CustomerService;
import com.enoca.etrade.business.dtos.request.CreateCustomerRequest;
import com.enoca.etrade.business.dtos.response.CreatedCustomerResponse;
import com.enoca.etrade.core.utilities.mapping.ModelMapperService;
import com.enoca.etrade.dataAccess.abstracts.CustomerRepository;
import com.enoca.etrade.entities.concretes.Customer;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Transactional
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CreatedCustomerResponse addCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer=this.modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
        customer.setCreateDate(LocalDateTime.now());
        customerRepository.save(customer);
        CreatedCustomerResponse createdCustomerResponse=this.modelMapperService.forResponse().map(customer,CreatedCustomerResponse.class);

        return createdCustomerResponse;
    }
}
