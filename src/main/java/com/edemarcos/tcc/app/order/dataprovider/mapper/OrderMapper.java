package com.edemarcos.tcc.app.order.dataprovider.mapper;

import com.edemarcos.tcc.app.customer.dataproviders.mapper.CustomerMapper;
import com.edemarcos.tcc.app.order.dataprovider.model.OrderModel;
import com.edemarcos.tcc.app.user.dataproviders.mapper.UserMapper;
import com.edemarcos.tcc.domain.order.entities.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    public Order toOrder(OrderModel orderModel) {
        var customer = new CustomerMapper().toCustomer(orderModel.getCustomer());
        var user = new UserMapper().toEntity(orderModel.getUser());
        return new Order(
                orderModel.getId(),
                orderModel.getOrderDate(),
                orderModel.getStatus(),
                customer,
                user
        );
    }

    public OrderModel toOrderModel(Order order) {
        var customerModel = new CustomerMapper().toCustomerModel(order.getCustomer());
        var userModel = new UserMapper().toModel(order.getUser());
        return new OrderModel(
                order.getId(),
                order.getOrderDate(),
                order.getStatus(),
                customerModel,
                userModel
        );
    }

    public List<Order> toOrderList(List<OrderModel> orderModelList) {
        var orderList = new ArrayList<Order>();
        for (OrderModel orderModel : orderModelList) {
            orderList.add(toOrder(orderModel));
        }
        return orderList;
    }

}
