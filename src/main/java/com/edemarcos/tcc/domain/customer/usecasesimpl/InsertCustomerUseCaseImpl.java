package com.edemarcos.tcc.domain.customer.usecasesimpl;


import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.exceptions.CustomerUpdateException;
import com.edemarcos.tcc.domain.customer.usecases.InsertCustomerUseCase;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final CustomerDataProvider customerDataProvider;
    public InsertCustomerUseCaseImpl(CustomerDataProvider customerDataProvider){
        this.customerDataProvider = customerDataProvider;
    }

    @Override
    public Customer execute(Customer customer) {
        Field[] fields = Customer.class.getDeclaredFields();
        List<String> fieldsToCheck = Arrays.asList("name", "cpf", "dateOfBirth", "address", "phone", "email", "socialMedia");

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                if (fieldsToCheck.contains(field.getName()) && field.get(customer) == null) {
                    throw new CustomerUpdateException("O campo " + field.getName() + " não pode ser nulo.");
                }
                field.set(customer, field.get(customer));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return customerDataProvider.insert(customer);
    }
}
