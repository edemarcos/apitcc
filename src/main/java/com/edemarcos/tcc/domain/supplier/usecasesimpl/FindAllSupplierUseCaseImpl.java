package com.edemarcos.tcc.domain.supplier.usecasesimpl;

import com.edemarcos.tcc.domain.supplier.dataproviders.SupplierDataProvider;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import com.edemarcos.tcc.domain.supplier.usecases.FindAllSupplierUseCase;

import java.util.List;

public class FindAllSupplierUseCaseImpl implements FindAllSupplierUseCase {
    private final SupplierDataProvider supplierDataProvider;

    public FindAllSupplierUseCaseImpl(SupplierDataProvider supplierDataProvider){
        this.supplierDataProvider = supplierDataProvider;
    }

    @Override
    public List<Supplier> execute() {
        return supplierDataProvider.findAll();
    }
}
