package com.edemarcos.tcc.domain.order.dataproviders;

import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.order.entities.OrderItem;
import com.edemarcos.tcc.domain.product.entities.Product;

import java.util.List;

public interface OrderDataProvider {
    Order insert(Order order);
    Order findById(Long id);
    List<Order> findAll();
    void update(Order order);
    void delete(Long id);
    List<OrderItem> insertOrderItems(List<OrderItem> orderItems);
}
