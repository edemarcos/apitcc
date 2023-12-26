package com.edemarcos.tcc.domain.order.usecasesimpl;

import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.order.dataproviders.OrderDataProvider;
import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.order.entities.OrderItem;
import com.edemarcos.tcc.domain.order.enums.OrderStatus;
import com.edemarcos.tcc.domain.order.exceptions.OrderInsertionException;
import com.edemarcos.tcc.domain.order.usecases.GetProductOrderUseCase;
import com.edemarcos.tcc.domain.order.usecases.UpdateOrderUseCase;
import com.edemarcos.tcc.domain.user.entities.User;
import com.edemarcos.tcc.domain.user.usecases.FindByIdUserUseCase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UpdateOrderUseCaseImpl implements UpdateOrderUseCase {
    private OrderDataProvider orderDataProvider;
    private FindByIdCustomerUseCase findByIdCustomerUseCase;

    private FindByIdUserUseCase findByIdUserUseCase;

    private GetProductOrderUseCase getProductOrderUseCase;

    public UpdateOrderUseCaseImpl(OrderDataProvider orderDataProvider,
                                  FindByIdCustomerUseCase findByIdCustomerUseCase,
                                  FindByIdUserUseCase findByIdUserUseCase,
                                  GetProductOrderUseCase getProductOrderUseCase) {
        this.orderDataProvider = orderDataProvider;
        this.findByIdCustomerUseCase = findByIdCustomerUseCase;
        this.findByIdUserUseCase = findByIdUserUseCase;
        this.getProductOrderUseCase = getProductOrderUseCase;
    }
    @Override
    public Order execute(Order order, Long id) {
        Order orderOfUpdate = orderDataProvider.findById(id);
        //talvez isso não precise
        var orderItemsUpdate = orderDataProvider.findOrderItemsByOrderId(id);

        //var orderItemsUpdate = orderOfUpdate.getOrderItems();
        if (orderOfUpdate == null) {
            throw new OrderInsertionException("O pedido informado não existe.");
        }

        if (orderOfUpdate.getStatus() != OrderStatus.PENDING) {
            throw new OrderInsertionException("O pedido já foi enviado e não pode ser alterado.");
        }

        Customer customerOfInsert = findByIdCustomerUseCase.execute(orderOfUpdate.getCustomer().getId());
        User userOfInsert = findByIdUserUseCase.execute(orderOfUpdate.getUser().getId());

        if (customerOfInsert == null) {
            throw new OrderInsertionException("O cliente informado não existe.");
        }
        if (userOfInsert == null) {
            throw new OrderInsertionException("O usuario informado não existe.");
        }

        var orderItems = order.getOrderItems();
        orderItems = getProductOrderUseCase.execute(orderItems);
        var newOrderItems = new ArrayList<OrderItem>();

        for (int i = 0; i < orderItems.size(); i++) {
            int igual = 0;
            for (int j = 0; j < orderItemsUpdate.size(); j++) {
                if (orderItems.get(i).getProduct().getId() == orderItemsUpdate.get(j).getProduct().getId()) {
                    orderItemsUpdate.get(j).setQuantity(orderItems.get(i).getQuantity() + orderItemsUpdate.get(j).getQuantity());
                    orderItemsUpdate.get(j).setTotalItem(orderItems.get(i).getTotalItem() + orderItemsUpdate.get(j).getTotalItem());
                    igual = 1;
                }
            }
            if (igual == 0) {
                newOrderItems.add(orderItems.get(i));
            }
        }

        orderItemsUpdate.addAll(newOrderItems);
        orderItemsUpdate.stream().forEach(orderItem -> orderItem.setOrderId(orderOfUpdate.getId()));
        orderItems = orderItemsUpdate;

        orderOfUpdate.setOrderItems(orderItemsUpdate);

        orderOfUpdate.setOrderDate(LocalDateTime.now());
        order = orderOfUpdate;
        var orderInserted = orderDataProvider.update(order);

        orderInserted.setOrderItems(orderDataProvider.updateOrderItems(orderItems));

        return orderInserted;
    }
}
