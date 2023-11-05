package com.edemarcos.tcc.domain.order.usecases;

import com.edemarcos.tcc.domain.order.entities.OrderItem;
import com.edemarcos.tcc.domain.product.entities.Product;

import java.util.List;

public interface GetProductOrderUseCase {
    List<OrderItem> execute(List<OrderItem> orderItems);
}
