package com.edemarcos.tcc.app.supplier.entrypoint.controller.response;

import lombok.Data;

@Data
public class SupplierResponse {
    private Long id;
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
