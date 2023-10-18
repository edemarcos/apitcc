package com.edemarcos.tcc.domain.customer.usecases;

import com.edemarcos.tcc.domain.customer.entities.Customer;

public interface UpdateCustomerUseCase {
    void execute(Customer customer, Long id);
}
