package com.edemarcos.tcc.domain.order.entities;

import com.edemarcos.tcc.domain.product.entities.Product;

public class OrderItem {
    private Long id;
    private Product product;
    private Order order;
    private int quantity;
    private Double unitPrice;
    private Double totalItem;

    public OrderItem(Long id, Product product, Order order, int quantity, Double unitPrice, Double totalItem) {
        this.id = id;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalItem = totalItem;
    }

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Double totalItem) {
        this.totalItem = totalItem;
    }
}
