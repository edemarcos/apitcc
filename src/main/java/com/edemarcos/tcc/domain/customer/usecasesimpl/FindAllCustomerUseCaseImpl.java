package com.edemarcos.tcc.domain.customer.usecasesimpl;

import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.usecases.FindAllCustomerUseCase;

import java.util.List;

public class FindAllCustomerUseCaseImpl implements FindAllCustomerUseCase {

    private final CustomerDataProvider customerDataProvider;

    public FindAllCustomerUseCaseImpl(CustomerDataProvider customerDataProvider){
        this.customerDataProvider = customerDataProvider;
    }
    @Override
    public List<Customer> execute() {
        return customerDataProvider.findAll();
    }
}
