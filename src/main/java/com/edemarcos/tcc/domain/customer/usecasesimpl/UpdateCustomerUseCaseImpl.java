package com.edemarcos.tcc.domain.customer.usecasesimpl;


import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.exceptions.CustomerUpdateException;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.customer.usecases.UpdateCustomerUseCase;

import java.lang.reflect.Field;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindByIdCustomerUseCase findByIdCustomerUseCase;

    private final CustomerDataProvider customerDataProvider;

    public UpdateCustomerUseCaseImpl(FindByIdCustomerUseCase findByIdCustomerUseCase, CustomerDataProvider customerDataProvider){
        this.findByIdCustomerUseCase = findByIdCustomerUseCase;
        this.customerDataProvider = customerDataProvider;
    }
    @Override
    public void execute(Customer customer, Long id) {
        Customer customerUpdate = findByIdCustomerUseCase.findById(id);
        customer.setId(id);

        Field[] fields = Customer.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                if (field.get(customer) == null) {
                    throw new CustomerUpdateException("O campo " + field.getName() + " não pode ser nulo.");
                }

                field.set(customerUpdate, field.get(customer));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        customerDataProvider.update(customerUpdate);
    }

}
