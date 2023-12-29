package com.edemarcos.tcc.app.order.dataprovider.mapper;

import com.edemarcos.tcc.app.order.dataprovider.model.OrderItemModel;
import com.edemarcos.tcc.app.product.dataproviders.mapper.ProductMapper;
import com.edemarcos.tcc.domain.order.entities.OrderItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemMapper {

    private ProductMapper productMapper = new ProductMapper();
    public OrderItemModel toModel(OrderItem orderItem) {
        var orderItemModel = new OrderItemModel();

        var product = productMapper.toProductModel(orderItem.getProduct());
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
        orderItem.setProduct(productMapper.toProduct(orderItemModel.getProduct()));
        orderItem.setOrderId(orderItemModel.getOrderId());
        orderItem.setQuantity(orderItemModel.getQuantity());
        orderItem.setUnitPrice(orderItemModel.getUnitPrice());
        orderItem.setTotalItem(orderItemModel.getTotalItem());
        return orderItem;
    }
    public List<OrderItem> toEntityList(List<OrderItemModel> orderItemModelList) {
        return orderItemModelList.stream()
                .map(orderItemModel -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setId(orderItemModel.getId());
                    orderItem.setProduct(productMapper.toProduct(orderItemModel.getProduct()));
                    orderItem.setOrderId(orderItemModel.getOrderId());
                    orderItem.setQuantity(orderItemModel.getQuantity());
                    orderItem.setUnitPrice(orderItemModel.getUnitPrice());
                    orderItem.setTotalItem(orderItemModel.getTotalItem());
                    return orderItem;
                })
                .collect(Collectors.toList());
    }

    public List<OrderItemModel> toModelList(List<OrderItem> orderItemList) {
        return orderItemList.stream().map(this::toModel).collect(Collectors.toList());
    }

}
