package com.edemarcos.tcc.app.order.entrypoint.request;

import com.edemarcos.tcc.domain.order.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequest {

    private LocalDateTime orderDate = LocalDateTime.now();
    private OrderStatus status;
    private Long customerid;
    private Long userid;
    private List<OrderItemRequest> items;


}


