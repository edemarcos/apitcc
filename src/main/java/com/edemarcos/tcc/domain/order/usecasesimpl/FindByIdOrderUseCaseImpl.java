package com.edemarcos.tcc.domain.order.usecasesimpl;

import com.edemarcos.tcc.domain.order.dataproviders.OrderDataProvider;
import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.order.exceptions.OrderNotFoundException;
import com.edemarcos.tcc.domain.order.usecases.FindByIdOrderUseCase;

public class FindByIdOrderUseCaseImpl implements FindByIdOrderUseCase {
    private OrderDataProvider orderDataProvider;

    public FindByIdOrderUseCaseImpl(OrderDataProvider orderDataProvider) {
        this.orderDataProvider = orderDataProvider;
    }
    @Override
    public Order execute(Long id) {
        var order = orderDataProvider.findById(id);
        if (order == null) {
            throw new OrderNotFoundException(id);
        }
        return order;
    }
}
