package com.edemarcos.tcc.domain.supplier.usecasesimpl;

import com.edemarcos.tcc.domain.supplier.dataproviders.SupplierDataProvider;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import com.edemarcos.tcc.domain.supplier.exceptions.SupplierNotFoundException;
import com.edemarcos.tcc.domain.supplier.usecases.FindByIdSupplierUseCase;

public class FindByIdSupplierUseCaseImpl implements FindByIdSupplierUseCase {

    private final SupplierDataProvider supplierDataProvider;

    public FindByIdSupplierUseCaseImpl(SupplierDataProvider supplierDataProvider){
        this.supplierDataProvider = supplierDataProvider;
    }
    @Override
    public Supplier execute(Long id) {
        try {
            return supplierDataProvider.findById(id);
        } catch (SupplierNotFoundException e) {
            throw new SupplierNotFoundException(id);
        }

    }
}
