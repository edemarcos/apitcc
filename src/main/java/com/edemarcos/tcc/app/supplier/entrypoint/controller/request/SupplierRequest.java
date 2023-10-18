package com.edemarcos.tcc.app.supplier.entrypoint.controller.request;

import lombok.Data;

@Data
public class SupplierRequest {
    private String companyName;
    private String cnpj;
    private String legalName;
    private String stateRegistration;
    private String companyAddress;
    private String phone;
    private String email;
    private String website;
    private String socialMedia;
}
