package com.edemarcos.tcc.domain.order.usecases;

import com.edemarcos.tcc.domain.order.entities.Order;

public interface UpdateOrderUseCase {
    Order execute(Order order, Long id);
}
