package com.edemarcos.tcc.app.customer.dataproviders.mapper;

import com.edemarcos.tcc.app.customer.dataproviders.model.CustomerModel;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {
    public CustomerModel toCustomerModel(Customer customer) {
        return new CustomerModel(
                customer.getId(), customer.getName(), customer.getCpf(), customer.getDateOfBirth(), customer.getAddress(), customer.getPhone(), customer.getEmail(), customer.getSocialMedia());
    }
    public Customer toCustomer(CustomerModel customerModel) {
        var customer = new Customer(
                customerModel.getId(), customerModel.getName(), customerModel.getCpf(), customerModel.getDateOfBirth(), customerModel.getAddress(), customerModel.getPhone(), customerModel.getEmail(), customerModel.getSocialMedia());
        return customer;
    }

    public List<Customer> toCustomerList(List<CustomerModel> customerModelList) {
        return customerModelList.stream().map(this::toCustomer).collect(java.util.stream.Collectors.toList());
    }
}
