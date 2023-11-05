package com.edemarcos.tcc.domain.order.entities;

import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.order.enums.OrderStatus;
import com.edemarcos.tcc.domain.user.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private int status;
    private Customer customer;
    private User user;
    private List<OrderItem> orderItems;

    public Order() {
    }


    public Order(Long id, LocalDateTime orderDate, int status, Customer customer, User user, List<OrderItem> orderItems) {
        this.id = id;
        this.orderDate = orderDate;
        this.status = status;
        this.customer = customer;
        this.user = user;
        this.orderItems = orderItems;
    }

    public Order(Long id, LocalDateTime orderDate, int value, Customer customer, User user) {
        this.id = id;
        this.orderDate = orderDate;
        this.status = value;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
