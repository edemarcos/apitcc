package com.edemarcos.tcc.domain.customer.usecasesimpl;

import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.exceptions.CustomerNotFoundException;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;

public class FindByIdCustomerUseCaseImpl implements FindByIdCustomerUseCase {

    private final CustomerDataProvider customerDataProvider;

    public FindByIdCustomerUseCaseImpl(CustomerDataProvider customerDataProvider){
        this.customerDataProvider = customerDataProvider;
    }
    @Override
    public Customer execute(Long id) {
        var customer = customerDataProvider.findById(id);
        if (customer == null) {
            throw new CustomerNotFoundException(id);
        }
        return customer;
    }
}
