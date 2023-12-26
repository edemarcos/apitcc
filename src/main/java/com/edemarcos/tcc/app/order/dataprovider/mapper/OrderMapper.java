package com.edemarcos.tcc.app.order.dataprovider.mapper;

import com.edemarcos.tcc.app.customer.dataproviders.mapper.CustomerMapper;
import com.edemarcos.tcc.app.order.dataprovider.model.OrderItemModel;
import com.edemarcos.tcc.app.order.dataprovider.model.OrderModel;
import com.edemarcos.tcc.app.user.dataproviders.mapper.UserMapper;
import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.order.entities.OrderItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    private OrderItemMapper orderItemMapper = new OrderItemMapper();

    public Order toOrder(OrderModel orderModel) {
        var customer = new CustomerMapper().toCustomer(orderModel.getCustomer());
        var user = new UserMapper().toEntity(orderModel.getUser());
        var order = new Order(
                orderModel.getId(),
                orderModel.getOrderDate(),
                orderModel.getStatus().getValue(),
                customer,
                user,
                null
        );
        List<OrderItem> orderItems = orderItemMapper.toEntityList(orderModel.getOrderItems());
        order.setOrderItems(orderItems);

        return order;
    }


    public OrderModel toOrderModel(Order order) {
        var customerModel = new CustomerMapper().toCustomerModel(order.getCustomer());
        var userModel = new UserMapper().toModel(order.getUser());
        var orderModel = new OrderModel(
                order.getId(),
                order.getOrderDate(),
                order.getStatus(),
                customerModel,
                userModel,
                orderItemMapper.toModelList(order.getOrderItems())
        );
        return orderModel;
    }

    public List<Order> toOrderList(List<OrderModel> orderModelList) {
        var orderList = new ArrayList<Order>();
        for (OrderModel orderModel : orderModelList) {
            orderList.add(toOrder(orderModel));
        }
        return orderList;
    }

}
