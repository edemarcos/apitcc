package com.edemarcos.tcc.app.order.entrypoint.response;

import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.order.enums.OrderStatus;
import com.edemarcos.tcc.domain.user.entities.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {

    private Long id;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Customer customer;
    private String user;
    private List<OrderItemResponse> items;
}
