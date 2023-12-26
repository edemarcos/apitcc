package com.edemarcos.tcc.app.order.dataprovider.mapper;

import com.edemarcos.tcc.app.order.dataprovider.model.OrderItemModel;

import com.edemarcos.tcc.app.product.dataproviders.mapper.ProductMapper;
import com.edemarcos.tcc.domain.order.entities.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemMapper {

    public OrderItemModel toModel(OrderItem orderItem) {
        var orderItemModel = new OrderItemModel();

        var product = new ProductMapper().toProductModel(orderItem.getProduct());
        orderItemModel.setId(orderItem.getId());
        orderItemModel.setProduct(product);
        orderItemModel.setOrderId(orderItem.getOrderId());
        orderItemModel.setQuantity(orderItem.getQuantity());
        orderItemModel.setUnitPrice(orderItem.getUnitPrice());
        orderItemModel.setTotalItem(orderItem.getTotalItem());
        return orderItemModel;
    }

    public OrderItem toEntity(OrderItemModel orderItemModel) {
        var orderItem = new OrderItem();
        orderItem.setProduct(new ProductMapper().toProduct(orderItemModel.getProduct()));
        orderItem.setOrderId(orderItemModel.getOrderId());
        orderItem.setQuantity(orderItemModel.getQuantity());
        orderItem.setUnitPrice(orderItemModel.getUnitPrice());
        orderItem.setTotalItem(orderItemModel.getTotalItem());
        return orderItem;
    }

    public List<OrderItem> toEntityList(List<OrderItemModel> orderItemModelList) {
        var orderItemList = new ArrayList<OrderItem>();

        if (!orderItemModelList.isEmpty()){
            for (OrderItemModel orderItemModel : orderItemModelList) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(orderItemModel.getId());
                orderItem.setProduct(new ProductMapper().toProduct(orderItemModel.getProduct()));
                orderItem.setOrderId(orderItemModel.getOrderId());
                orderItem.setQuantity(orderItemModel.getQuantity());
                orderItem.setUnitPrice(orderItemModel.getUnitPrice());
                orderItem.setTotalItem(orderItemModel.getTotalItem());
                orderItemList.add(orderItem);
            }
        }

        return orderItemList;
    }

    public List<OrderItemModel> toModelList(List<OrderItem> orderItemList) {
        var orderItemModelList = new ArrayList<OrderItemModel>();
        for (OrderItem orderItem : orderItemList) {
            orderItemModelList.add(toModel(orderItem));
        }
        return orderItemModelList;
    }

}
