package com.edemarcos.tcc.app.supplier.dataproviders.repository;

import com.edemarcos.tcc.app.supplier.dataproviders.model.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {
}
