package com.edemarcos.tcc.domain.supplier.usecasesimpl;


import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.exceptions.CustomerUpdateException;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.customer.usecases.UpdateCustomerUseCase;
import com.edemarcos.tcc.domain.supplier.dataproviders.SupplierDataProvider;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import com.edemarcos.tcc.domain.supplier.exceptions.SupplierUpdateException;
import com.edemarcos.tcc.domain.supplier.usecases.FindByIdSupplierUseCase;
import com.edemarcos.tcc.domain.supplier.usecases.UpdateSupplierUseCase;

import java.lang.reflect.Field;

public class UpdateSupplierUseCaseImpl implements UpdateSupplierUseCase {

    private final FindByIdSupplierUseCase findByIdSupplierUseCase;

    private final SupplierDataProvider supplierDataProvider;

    public UpdateSupplierUseCaseImpl(FindByIdSupplierUseCase findByIdSupplierUseCase, SupplierDataProvider supplierDataProvider){
        this.findByIdSupplierUseCase = findByIdSupplierUseCase;
        this.supplierDataProvider = supplierDataProvider;
    }
    @Override
    public void execute(Supplier supplier, Long id) {
        Supplier supplierUpdate = findByIdSupplierUseCase.execute(id);
        supplier.setId(id);

        Field[] fields = Supplier.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                if (field.get(supplier) == null) {
                    throw new SupplierUpdateException("O campo " + field.getName() + " não pode ser nulo.");
                }

                field.set(supplierUpdate, field.get(supplier));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        supplierDataProvider.update(supplierUpdate);
    }

}
