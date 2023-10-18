package com.edemarcos.tcc.app.product.entrypoint.controller.response;

import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.product.enums.ProductStatus;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private Category category;
    private String description;
    private Double unitPrice;
    private Supplier supplier;
    private Integer initialQuantity;
    private LocalDateTime registrationDate;
    private Double weight;
    private String dimensions;
    private String status;
}
