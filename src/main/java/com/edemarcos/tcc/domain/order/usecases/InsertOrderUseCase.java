package com.edemarcos.tcc.domain.order.usecases;

import com.edemarcos.tcc.domain.order.entities.Order;

public interface InsertOrderUseCase {
    Order execute(Order order);
}
