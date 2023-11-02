package com.edemarcos.tcc.domain.order.usecasesimpl;

import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.order.dataproviders.OrderDataProvider;
import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.order.enums.OrderStatus;
import com.edemarcos.tcc.domain.order.exceptions.OrderInsertionException;
import com.edemarcos.tcc.domain.order.usecases.InsertOrderUseCase;
import com.edemarcos.tcc.domain.user.entities.User;
import com.edemarcos.tcc.domain.user.usecases.FindByIdUserUseCase;

import java.time.LocalDateTime;


public class InsertOrderUseCaseImpl implements InsertOrderUseCase {
    private OrderDataProvider orderDataProvider;
    private FindByIdCustomerUseCase findByIdCustomerUseCase;
    private FindByIdUserUseCase findByIdUserUseCase;

    public InsertOrderUseCaseImpl(OrderDataProvider orderDataProvider, FindByIdCustomerUseCase findByIdCustomerUseCase, FindByIdUserUseCase findByIdUserUseCase) {
        this.orderDataProvider = orderDataProvider;
        this.findByIdCustomerUseCase = findByIdCustomerUseCase;
        this.findByIdUserUseCase = findByIdUserUseCase;
    }

    @Override
    public Order execute(Order order) {
        Customer customerOfInsert = findByIdCustomerUseCase.execute(order.getCustomer().getId());
        User userOfInsert = findByIdUserUseCase.execute(order.getUser().getId());

        if (customerOfInsert == null) {
            throw new OrderInsertionException("O cliente informado não existe.");
        }
        if (userOfInsert == null) {
            throw new OrderInsertionException("O usuario informado não existe.");
        }

        if (order.getStatus() == null) {
            order.setStatus(OrderStatus.PENDING);
        }

        order.setOrderDate(order.getOrderDate() == null ? LocalDateTime.now() : order.getOrderDate());

        return orderDataProvider.insert(order);
    }
}
