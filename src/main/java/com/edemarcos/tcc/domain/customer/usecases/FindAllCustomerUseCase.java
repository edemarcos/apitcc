package com.edemarcos.tcc.domain.customer.usecases;

import com.edemarcos.tcc.domain.customer.entities.Customer;

import java.util.List;

public interface FindAllCustomerUseCase {

    List<Customer> execute();
}
