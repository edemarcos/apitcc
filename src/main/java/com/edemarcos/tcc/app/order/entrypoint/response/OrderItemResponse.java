package com.edemarcos.tcc.app.order.entrypoint.response;

import com.edemarcos.tcc.app.product.entrypoint.controller.response.ProductResponse;
import lombok.Data;

@Data
public class OrderItemResponse {
    private OrderItemProductResponse product;
    private Integer quantity;
    private Double unitPrice;
    private Double totalItem;
}
