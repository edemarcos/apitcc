package com.edemarcos.tcc.app.supplier.dataproviders.mapper;

import com.edemarcos.tcc.app.supplier.dataproviders.model.SupplierModel;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplierMapper {
    public SupplierModel toSupplierModel(Supplier supplier) {
        return new SupplierModel(
                supplier.getId(),
                supplier.getCompanyName(),
                supplier.getCnpj(),
                supplier.getLegalName(),
                supplier.getStateRegistration(),
                supplier.getCompanyAddress(),
                supplier.getPhone(),
                supplier.getEmail(),
                supplier.getWebsite(),
                supplier.getSocialMedia());

    }

    public Supplier toSupplier(SupplierModel supplierModel) {
        return new Supplier(
                supplierModel.getId(),
                supplierModel.getCompanyName(),
                supplierModel.getCnpj(),
                supplierModel.getLegalName(),
                supplierModel.getStateRegistration(),
                supplierModel.getCompanyAddress(),
                supplierModel.getPhone(),
                supplierModel.getEmail(),
                supplierModel.getWebsite(),
                supplierModel.getSocialMedia());
    }

    public List<Supplier> toSupplierList(List<SupplierModel> supplierModelList) {
        return supplierModelList.stream().map(this::toSupplier).collect(Collectors.toList());
    }
}


