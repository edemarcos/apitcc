package com.edemarcos.tcc.domain.customer.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer {

    private Long id;
    private String name;
    private String cpf;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String email;
    private String socialMedia;

    public Customer() {
    }

    public Customer(Long id, String name, String cpf, LocalDate dateOfBirth, String address, String phone, String email, String socialMedia) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.socialMedia = socialMedia;
    }

    public Customer(String name, String cpf, LocalDate dateOfBirth, String address, String phone, String email, String socialMedia) {
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.socialMedia = socialMedia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }
}
