package com.edemarcos.tcc.domain.supplier.usecasesimpl;


import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.exceptions.CustomerUpdateException;
import com.edemarcos.tcc.domain.customer.usecases.InsertCustomerUseCase;
import com.edemarcos.tcc.domain.supplier.dataproviders.SupplierDataProvider;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import com.edemarcos.tcc.domain.supplier.exceptions.SupplierInsertionException;
import com.edemarcos.tcc.domain.supplier.usecases.InsertSupplierUseCase;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class InsertSupplierUseCaseImpl implements InsertSupplierUseCase {

    private final SupplierDataProvider supplierDataProvider;
    public InsertSupplierUseCaseImpl(SupplierDataProvider supplierDataProvider){
        this.supplierDataProvider = supplierDataProvider;
    }

    @Override
    public Supplier execute(Supplier supplier) {
        Field[] fields = Supplier.class.getDeclaredFields();
        List<String> fieldsToCheck = Arrays.asList("companyName", "cnpj", "legalName", "stateRegistration", "companyAddress", "phone", "email", "website", "socialMedia");

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                if (fieldsToCheck.contains(field.getName()) && field.get(supplier) == null) {
                    throw new SupplierInsertionException("O campo " + field.getName() + " não pode ser nulo.");
                }
                field.set(supplier, field.get(supplier));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return supplierDataProvider.insert(supplier);
    }
}
