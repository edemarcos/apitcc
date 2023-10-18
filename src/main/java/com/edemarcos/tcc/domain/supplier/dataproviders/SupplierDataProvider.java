package com.edemarcos.tcc.domain.supplier.dataproviders;

import com.edemarcos.tcc.domain.supplier.entities.Supplier;

import java.util.List;

public interface SupplierDataProvider {
    Supplier insert(Supplier supplier);
    void update(Supplier supplier);
    Supplier findById(Long id);
    void delete(Long id);
    List<Supplier> findAll();
}
