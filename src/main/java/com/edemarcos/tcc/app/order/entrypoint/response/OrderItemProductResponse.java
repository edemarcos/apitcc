package com.edemarcos.tcc.app.order.entrypoint.response;

import lombok.Data;

@Data
public class OrderItemProductResponse {
    Long id;
    String name;
    String description;
    Double unitPrice;
}
