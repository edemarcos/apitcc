package com.edemarcos.tcc.app.product.dataproviders.model;

import com.edemarcos.tcc.app.category.dataproviders.model.CategoryModel;
import com.edemarcos.tcc.app.supplier.dataproviders.model.SupplierModel;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.product.enums.ProductStatus;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category")
    private CategoryModel category;
    private String description;
    private Double unitPrice;
    @ManyToOne
    @JoinColumn(name = "supplier")
    private SupplierModel supplier;
    private Integer initialQuantity;
    private LocalDateTime registrationDate;
    private Double weight;
    private String dimensions;
    private ProductStatus status;

}
