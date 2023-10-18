package com.edemarcos.tcc.domain.supplier.usecases;

import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;

public interface UpdateSupplierUseCase {
    void execute(Supplier supplier, Long id);
}
