package com.edemarcos.tcc.domain.customer.usecasesimpl;

import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.usecases.DeleteCustomerByIdUseCase;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    private final FindByIdCustomerUseCase findByIdCustomerUseCase;
    private final CustomerDataProvider customerDataProvider;
    public DeleteCustomerByIdUseCaseImpl(FindByIdCustomerUseCase findByIdCustomerUseCase, CustomerDataProvider customerDataProvider){
        this.findByIdCustomerUseCase = findByIdCustomerUseCase;
        this.customerDataProvider = customerDataProvider;
    }
    @Override
    public void delete(Long id) {
        findByIdCustomerUseCase.findById(id);
        customerDataProvider.delete(id);

    }
}
