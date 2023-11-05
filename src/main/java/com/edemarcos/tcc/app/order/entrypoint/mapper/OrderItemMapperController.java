package com.edemarcos.tcc.app.order.entrypoint.mapper;

import com.edemarcos.tcc.app.order.entrypoint.request.OrderItemRequest;
import com.edemarcos.tcc.app.order.entrypoint.response.OrderItemProductResponse;
import com.edemarcos.tcc.app.order.entrypoint.response.OrderItemResponse;
import com.edemarcos.tcc.app.product.entrypoint.controller.mapper.ProductMapperController;
import com.edemarcos.tcc.app.product.entrypoint.controller.response.ProductResponse;
import com.edemarcos.tcc.domain.order.entities.OrderItem;
import com.edemarcos.tcc.domain.product.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderItemMapperController {

    public OrderItem toOrderItem(OrderItemRequest orderItemRequest) {
        var orderItem = new OrderItem();
        orderItem.setId(orderItemRequest.getProductId());
        orderItem.setQuantity(orderItemRequest.getQuantity());
        return orderItem;
    }

    public List<OrderItem> toOrderItemList(List<OrderItemRequest> orderItemRequestList) {
        var orderItemList = new ArrayList<OrderItem>();
        for (OrderItemRequest orderItemRequest : orderItemRequestList) {
            orderItemList.add(toOrderItem(orderItemRequest));
        }
        return orderItemList;
    }
    public List<OrderItemResponse> toOrderItemResponseList(List<OrderItem> orderItemList) {
        var orderItemResponseList = new ArrayList<OrderItemResponse>();
        for (OrderItem orderItem : orderItemList) {
            orderItemResponseList.add(toOrderItemResponse(orderItem));
        }
        return orderItemResponseList;
    }

    public OrderItemResponse toOrderItemResponse(OrderItem orderItem) {
        var orderItemResponse = new OrderItemResponse();
        orderItemResponse.setProduct(toOrderItemProductResponse(orderItem.getProduct()));
        orderItemResponse.setQuantity(orderItem.getQuantity());
        orderItemResponse.setUnitPrice(orderItem.getUnitPrice());
        orderItemResponse.setTotalItem(orderItem.getTotalItem());
        return orderItemResponse;
    }

    public OrderItemProductResponse toOrderItemProductResponse(Product product) {
        var orderItemProductResponse = new OrderItemProductResponse();
        orderItemProductResponse.setId(product.getId());
        orderItemProductResponse.setName(product.getName());
        orderItemProductResponse.setDescription(product.getDescription());
        orderItemProductResponse.setUnitPrice(product.getUnitPrice());
        return orderItemProductResponse;
    }
}
