package com.edemarcos.tcc.app.supplier.entrypoint.controller.mapper;

import com.edemarcos.tcc.app.supplier.entrypoint.controller.request.SupplierRequest;
import com.edemarcos.tcc.app.supplier.entrypoint.controller.response.SupplierResponse;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplierMapperController {
    public Supplier toSupplier(SupplierRequest supplierRequest) {
        Supplier supplier = new Supplier();
        supplier.setCompanyName(supplierRequest.getCompanyName());
        supplier.setCnpj(supplierRequest.getCnpj());
        supplier.setLegalName(supplierRequest.getLegalName());
        supplier.setStateRegistration(supplierRequest.getStateRegistration());
        supplier.setCompanyAddress(supplierRequest.getCompanyAddress());
        supplier.setPhone(supplierRequest.getPhone());
        supplier.setEmail(supplierRequest.getEmail());
        supplier.setWebsite(supplierRequest.getWebsite());
        supplier.setSocialMedia(supplierRequest.getSocialMedia());
        return supplier;
    }

    public SupplierResponse toSupplierResponse(Supplier supplier) {
        SupplierResponse supplierResponse = new SupplierResponse();
        supplierResponse.setId(supplier.getId());
        supplierResponse.setCompanyName(supplier.getCompanyName());
        supplierResponse.setCnpj(supplier.getCnpj());
        supplierResponse.setLegalName(supplier.getLegalName());
        supplierResponse.setStateRegistration(supplier.getStateRegistration());
        supplierResponse.setCompanyAddress(supplier.getCompanyAddress());
        supplierResponse.setPhone(supplier.getPhone());
        supplierResponse.setEmail(supplier.getEmail());
        supplierResponse.setWebsite(supplier.getWebsite());
        supplierResponse.setSocialMedia(supplier.getSocialMedia());
        return supplierResponse;
    }

    public List<SupplierResponse> toSupplierResponseList(List<Supplier> supplierList) {
        return supplierList.stream().map(this::toSupplierResponse).collect(Collectors.toList());
    }
}
