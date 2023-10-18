package com.edemarcos.tcc.app.customer.entrypoint.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
@Data
public class CustomerRequest {
    private String name;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String email;
    private String socialMedia;

}
