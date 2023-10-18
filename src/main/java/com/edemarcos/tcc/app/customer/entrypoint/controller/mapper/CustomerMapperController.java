package com.edemarcos.tcc.app.customer.entrypoint.controller.mapper;

import com.edemarcos.tcc.app.customer.entrypoint.controller.request.CustomerRequest;
import com.edemarcos.tcc.app.customer.entrypoint.controller.response.CustomerResponse;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapperController {
    public Customer toCustomer(CustomerRequest customerRequest) {
        return new Customer(customerRequest.getName(), customerRequest.getCpf(), customerRequest.getDateOfBirth(), customerRequest.getAddress(), customerRequest.getPhone(), customerRequest.getEmail(), customerRequest.getSocialMedia());
    }
    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getId(),customer.getName(), customer.getCpf(), customer.getDateOfBirth(), customer.getAddress(), customer.getPhone(), customer.getEmail(), customer.getSocialMedia());
    }

    public List<CustomerResponse> toCustomerResponseList(List<Customer> customerList) {
        return customerList.stream().map(this::toCustomerResponse).collect(Collectors.toList());
    }

}
