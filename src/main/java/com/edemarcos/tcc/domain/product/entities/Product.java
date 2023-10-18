package com.edemarcos.tcc.domain.product.entities;

import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.product.enums.ProductStatus;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;

import java.time.LocalDateTime;
import java.util.Date;

public class Product {
    private Long id;
    private String name;
    private Long categoryId;
    private String description;
    private Double unitPrice;
    private Long supplierId;
    private Integer initialQuantity;
    private LocalDateTime registrationDate;
    private Double weight;
    private String dimensions;
    private ProductStatus status;
    private Category category;
    private Supplier supplier;

    public Product() {
    }

    public Product(Long id, String name, Long categoryId, String description, Double unitPrice, Long supplierId, Integer initialQuantity, LocalDateTime registrationDate, Double weight, String dimensions, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.supplierId = supplierId;
        this.initialQuantity = initialQuantity;
        this.registrationDate = registrationDate;
        this.weight = weight;
        this.dimensions = dimensions;
        this.status = status;
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

    public Integer getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Integer initialQuantity) {
        this.initialQuantity = initialQuantity;
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
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public Supplier getSupplier() {
        return supplier;
    }
}
