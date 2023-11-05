package com.edemarcos.tcc.app.order.entrypoint.request;

import lombok.Data;

@Data
public class OrderItemRequest {

    private Long productId;
    private Integer quantity;

}
