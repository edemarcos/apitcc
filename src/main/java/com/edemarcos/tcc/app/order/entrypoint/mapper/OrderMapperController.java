package com.edemarcos.tcc.app.order.entrypoint.mapper;

import com.edemarcos.tcc.app.order.entrypoint.request.OrderRequest;
import com.edemarcos.tcc.app.order.entrypoint.request.OrderRequestUpdate;
import com.edemarcos.tcc.app.order.entrypoint.response.OrderResponse;
import com.edemarcos.tcc.app.product.dataproviders.ProductDataProviderImpl;
import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.user.dataproviders.UserDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class OrderMapperController {

    private CustomerDataProvider customerDataProvider;

    private UserDataProvider userDataProvider;

    private ProductDataProviderImpl productDataProvider;

    public Order toOrder(OrderRequest orderRequest) {
        var customerModel = customerDataProvider.findById(orderRequest.getCustomerid());
        var supplierModel = userDataProvider.findById(orderRequest.getUserid());
        var order = new Order();
        order.setOrderDate(orderRequest.getOrderDate());
        order.setStatus(orderRequest.getStatus());
        order.setCustomer(customerModel);
        order.setUser(supplierModel);
        order.setOrderItems(new OrderItemMapperController(productDataProvider).toOrderItemList(orderRequest.getItems()));
        return order;
    }
    public Order toOrderUpdate (OrderRequestUpdate orderRequestUpdate) {
        var customerModel = customerDataProvider.findById(orderRequestUpdate.getCustomerid());
        var supplierModel = userDataProvider.findById(orderRequestUpdate.getUserid());
        var order = new Order();
        order.setOrderDate(orderRequestUpdate.getOrderDate());
        order.setCustomer(customerModel);
        order.setUser(supplierModel);
        order.setOrderItems(new OrderItemMapperController(productDataProvider).toOrderItemList(orderRequestUpdate.getItems()));
        return order;
    }


    public OrderResponse toOrderResponse(Order order) {
        var orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setOrderDate(order.getOrderDate());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setCustomer(order.getCustomer());
        orderResponse.setUser(order.getUser().getName());
        orderResponse.setItems(new OrderItemMapperController(productDataProvider).toOrderItemResponseList(order.getOrderItems()));
        return orderResponse;
    }

    public List<OrderResponse> toOrderResponseList(List<Order> orderList) {
        var orderResponseList = new ArrayList<OrderResponse>();
        for (Order order : orderList) {
            orderResponseList.add(toOrderResponse(order));
        }
        return orderResponseList;
    }
}
