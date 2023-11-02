package com.edemarcos.tcc.domain.order.entities;

import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.order.enums.OrderStatus;
import com.edemarcos.tcc.domain.user.entities.User;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private int status;
    private Customer customer;
    private User user;

    public Order() {
    }

    public Order(Long id, LocalDateTime orderDate, OrderStatus status, Customer customer, User user) {
        this.id = id;
        this.orderDate = orderDate;
        this.status = status.getValue();
        this.customer = customer;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        this.status = status.getValue();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
