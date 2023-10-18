package com.edemarcos.tcc.domain.customer.usecases;

import com.edemarcos.tcc.domain.customer.entities.Customer;

public interface InsertCustomerUseCase {
    Customer execute(Customer customer);
}
