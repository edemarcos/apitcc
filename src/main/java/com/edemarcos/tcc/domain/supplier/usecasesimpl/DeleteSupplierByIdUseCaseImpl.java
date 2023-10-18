package com.edemarcos.tcc.domain.supplier.usecasesimpl;

import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.usecases.DeleteCustomerByIdUseCase;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.supplier.dataproviders.SupplierDataProvider;
import com.edemarcos.tcc.domain.supplier.usecases.FindByIdSupplierUseCase;

public class DeleteSupplierByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    private final FindByIdSupplierUseCase findByIdSupplierUseCase;
    private final SupplierDataProvider supplierDataProvider;
    public DeleteSupplierByIdUseCaseImpl(FindByIdSupplierUseCase findByIdSupplierUseCase, SupplierDataProvider supplierDataProvider){
        this.findByIdSupplierUseCase = findByIdSupplierUseCase;
        this.supplierDataProvider = supplierDataProvider;
    }
    @Override
    public void delete(Long id) {
        findByIdSupplierUseCase.execute(id);
        supplierDataProvider.delete(id);

    }
}
