package com.edemarcos.tcc.app.order.dataprovider;

import com.edemarcos.tcc.app.order.dataprovider.mapper.OrderItemMapper;
import com.edemarcos.tcc.app.order.dataprovider.mapper.OrderMapper;
import com.edemarcos.tcc.app.order.dataprovider.model.OrderItemModel;
import com.edemarcos.tcc.app.order.dataprovider.model.OrderModel;
import com.edemarcos.tcc.app.order.dataprovider.repository.OrderItemRepository;
import com.edemarcos.tcc.app.order.dataprovider.repository.OrderRepository;
import com.edemarcos.tcc.domain.order.dataproviders.OrderDataProvider;
import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.order.entities.OrderItem;
import com.edemarcos.tcc.domain.order.exceptions.OrderNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDataProviderImpl implements OrderDataProvider {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper = new OrderMapper();

    private final OrderItemRepository orderItemRepository;

    private final OrderItemMapper orderItemMapper = new OrderItemMapper();

    public OrderDataProviderImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }
    @Override
    public Order insert(Order order) {
        OrderModel orderModel = orderMapper.toOrderModel(order);

        return orderMapper.toOrder(orderRepository.save(orderModel));
    }

    @Override
    public Order findById(Long id) {
        OrderModel orderModel = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        List<OrderItemModel> orderItemModelList = orderItemRepository.findByOrderId(orderModel.getId());
        orderModel.setOrderItems(orderItemModelList);

        return orderMapper.toOrder(orderModel);
    }

    @Override
    public List<Order> findAll() {
        List<OrderModel> orderModelList = orderRepository.findAll();

        orderModelList.forEach(orderModel -> {
            List<OrderItemModel> orderItemModelList = orderItemRepository.findByOrderId(orderModel.getId());
            orderModel.setOrderItems(orderItemModelList);
        });

        return orderMapper.toOrderList(orderModelList);
    }

    @Override
    public Order update(Order order) {
        OrderModel orderModel = orderMapper.toOrderModel(order);

        return orderMapper.toOrder(orderRepository.save(orderModel));
    }

    @Override
    public List<OrderItem> updateOrderItems(List<OrderItem> orderItems) {
        List<OrderItemModel> orderItensModel = orderItems.stream().map(orderItem -> {
            OrderItemModel orderItemModel = orderItemMapper.toModel(orderItem);
            return orderItemRepository.save(orderItemModel);
        }).collect(Collectors.toList());

        return orderItemMapper.toEntityList(orderItensModel);
    }

    @Override
    public void delete(Long id) {

    }
    @Override
    public List<OrderItem> insertOrderItems(List<OrderItem> orderItems) {
        List<OrderItemModel> orderItensModel = orderItems.stream().map(orderItem -> {
            OrderItemModel orderItemModel = orderItemMapper.toModel(orderItem);
            return orderItemRepository.save(orderItemModel);
        }).collect(Collectors.toList());

        return orderItemMapper.toEntityList(orderItensModel);
    }


    public List<OrderItem> findOrderItemsByOrderId(Long orderId) {
        List<OrderItemModel> orderItemModelList = orderItemRepository.findByOrderId(orderId);

        return orderItemMapper.toEntityList(orderItemModelList);
    }
}
