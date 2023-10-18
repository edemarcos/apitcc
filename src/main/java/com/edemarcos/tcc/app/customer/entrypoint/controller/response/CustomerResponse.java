package com.edemarcos.tcc.app.customer.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String email;
    private String socialMedia;
}
