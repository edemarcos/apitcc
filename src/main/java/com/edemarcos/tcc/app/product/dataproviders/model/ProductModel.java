package com.edemarcos.tcc.app.product.dataproviders.model;

import com.edemarcos.tcc.app.category.dataproviders.model.CategoryModel;
import com.edemarcos.tcc.app.order.dataprovider.model.OrderItemModel;
import com.edemarcos.tcc.app.supplier.dataproviders.model.SupplierModel;
import com.edemarcos.tcc.domain.product.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    @JoinColumn(name = "category_id")
    private CategoryModel category;
    private String description;
    private Double unitPrice;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierModel supplier;
    private Integer quantity;
    private LocalDateTime registrationDate;
    private Double weight;
    private String dimensions;
    private ProductStatus status;

}
