package com.edemarcos.tcc.domain.product.entities;

import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.product.enums.ProductStatus;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;

import java.time.LocalDateTime;

public class Product {
    private Long id;
    private String name;
    private Category category;
    private String description;
    private Double unitPrice;
    private Supplier supplier;
    private Integer quantity;
    private LocalDateTime registrationDate;
    private Double weight;
    private String dimensions;
    private int status;

    public Product() {
    }

    public Product(Long id, String name, Category category, String description, Double unitPrice,
                   Supplier supplier, Integer quantity, LocalDateTime registrationDate, Double weight,
                   String dimensions, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.unitPrice = unitPrice;
        this.supplier = supplier;
        this.quantity = quantity;
        this.registrationDate = registrationDate;
        this.weight = weight;
        this.dimensions = dimensions;
        this.status = status.getValue();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public ProductStatus getStatus() {
        return ProductStatus.valueOf(status);
    }

    public void setStatus(ProductStatus status) {
        this.status = status.getValue();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
