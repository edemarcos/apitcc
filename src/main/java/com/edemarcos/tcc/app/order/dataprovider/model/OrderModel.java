package com.edemarcos.tcc.app.order.dataprovider.model;

import com.edemarcos.tcc.app.customer.dataproviders.model.CustomerModel;
import com.edemarcos.tcc.app.user.dataproviders.model.UserModel;
import com.edemarcos.tcc.domain.order.enums.OrderStatus;
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
@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @OneToMany
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private List<OrderItemModel> orderItems;

    public OrderModel(Long id, LocalDateTime orderDate, OrderStatus status, CustomerModel customer, UserModel user) {
        this.id = id;
        this.orderDate = orderDate;
        this.status = status;
        this.customer = customer;
        this.user = user;
    }


}
