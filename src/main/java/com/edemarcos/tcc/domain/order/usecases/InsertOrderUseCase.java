package com.edemarcos.tcc.domain.order.usecases;

import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.product.entities.Product;

public interface InsertOrderUseCase {
    Order execute(Order order);
}
