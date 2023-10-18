package com.edemarcos.tcc.domain.supplier.entities;

public class Supplier {
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

    public Supplier() {
    }

    public Supplier(Long id, String companyName, String cnpj, String legalName, String stateRegistration, String companyAddress, String phone, String email, String website, String socialMedia) {
        this.id = id;
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.legalName = legalName;
        this.stateRegistration = stateRegistration;
        this.companyAddress = companyAddress;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.socialMedia = socialMedia;
    }

    public Supplier( String companyName, String cnpj, String legalName, String stateRegistration, String companyAddress, String phone, String email, String website, String socialMedia) {
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.legalName = legalName;
        this.stateRegistration = stateRegistration;
        this.companyAddress = companyAddress;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.socialMedia = socialMedia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }
}
