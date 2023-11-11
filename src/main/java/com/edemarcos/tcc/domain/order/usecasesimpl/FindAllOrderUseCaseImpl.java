package com.edemarcos.tcc.domain.order.usecasesimpl;

import com.edemarcos.tcc.domain.order.dataproviders.OrderDataProvider;
import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.order.usecases.FindAllOrderUseCase;

import java.util.List;

public class FindAllOrderUseCaseImpl implements FindAllOrderUseCase {

    private final OrderDataProvider orderDataProvider;

    public FindAllOrderUseCaseImpl(OrderDataProvider orderDataProvider) {
        this.orderDataProvider = orderDataProvider;
    }

    @Override
    public List<Order> execute() {
        return orderDataProvider.findAll();
    }
}
