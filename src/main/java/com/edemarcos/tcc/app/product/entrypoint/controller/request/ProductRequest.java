package com.edemarcos.tcc.app.product.entrypoint.controller.request;

import com.edemarcos.tcc.domain.product.enums.ProductStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductRequest {

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

}
