package com.edemarcos.tcc.domain.supplier.usecases;


import com.edemarcos.tcc.domain.supplier.entities.Supplier;

public interface FindByIdSupplierUseCase {
    Supplier execute(final Long id);
}
