package com.edemarcos.tcc.app.order.dataprovider.model;

import com.edemarcos.tcc.app.order.dataprovider.model.OrderModel;
import com.edemarcos.tcc.app.product.dataproviders.model.ProductModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_items")
@ToString(exclude = {"order"})
public class OrderItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductModel product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderModel order;

    private int quantity;
    private Double unitPrice;
    private Double totalItem;
}
