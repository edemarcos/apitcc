package com.edemarcos.tcc.domain.order.usecases;

import com.edemarcos.tcc.domain.order.entities.Order;

import java.util.List;

public interface FindAllOrderUseCase {
    List<Order> execute();
}
