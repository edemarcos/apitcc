package com.edemarcos.tcc.domain.supplier.usecases;

import com.edemarcos.tcc.domain.supplier.entities.Supplier;

import java.util.List;

public interface FindAllSupplierUseCase {
    List<Supplier> execute();
}
