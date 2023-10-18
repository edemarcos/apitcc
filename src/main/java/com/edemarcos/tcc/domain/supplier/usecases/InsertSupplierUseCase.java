package com.edemarcos.tcc.domain.supplier.usecases;

import com.edemarcos.tcc.domain.supplier.entities.Supplier;

public interface InsertSupplierUseCase {
    Supplier execute(Supplier supplier);
}
